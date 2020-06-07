package W3D3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class JDBCConcept_Q_1 {
	static Scanner scan = new Scanner(System.in);

	static int selection(){					// method to get a valid choice of user (Integer from 1 to 5)
		int choice;
		while (true){
			try{
				System.out.println("1 for Search By First Name");
				System.out.println("2 for Search By Last Name");
				System.out.println("3 for Search By Serial Number");
				System.out.println("4 for Search By Alias");
				System.out.println("5 for Search By Quote");
				System.out.print("Enter: ");
				choice = scan.nextInt();
				if(choice<0 || choice>5){
					throw new IndexOutOfBoundsException("Number is not in 1 to 5");
				}
				break;
			}catch (InputMismatchException e){
				System.out.println(e.toString());
				scan.next();
			}catch (IndexOutOfBoundsException e){
				System.out.println(e.toString());
			}
		}
		return choice;
	}

	static String enter_string(){					// method to take input a string
		System.out.print("Enter String: ");
		return scan.next();
	}

	static int enter_integer(){					// method to get a valid integer
		int choice;
		while (true){
			try{
				System.out.print("Enter Integer: ");
				choice = scan.nextInt();
				break;
			}catch (InputMismatchException e){
				System.out.println(e.toString());
				scan.next();
			}
		}
		return choice;
	}

	static String connect_db(String query){						// method to execute given query
		String result = "Data Not Found";						// String to store result
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";		// JDBC driver
		String DB_URL = "jdbc:mysql://localhost:3306/project";	// BD url

		String USER = "root";									// username
		String PASS = "root";									// password

		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);									// Register JDBC driver
			conn = DriverManager.getConnection(DB_URL, USER, PASS);		// Opening connection to DB
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);					// executing query
			result = "";
			while(rs.next()){											// using iterator and fetching data
				int serial_number  = rs.getInt("serial_number");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String also_known_as = rs.getString("also_known_as");
				String moto = rs.getString("moto");
				result += ("First Name: "+first_name+", Last Name: "+last_name+", Serial: "+serial_number+
						", Alias: "+also_known_as+", Quote: "+moto+"\n");
			}
			rs.close();
		} catch(Exception se){
			System.out.println(se.toString());
		} finally{									// closing opened connection
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				System.out.println(se.toString());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int choice = selection();			// using to get integer from 1 to 5
		String query="";
		if(choice == 3){
			int value = enter_integer();		// using to get integer for input
			query = "select * from w3d3_data where serial_number="+value+";";	// setting query for serial_number(Integer)
		}else {
			String value = enter_string();		// using to get string
			String key="";						// selecting key on the basis of choice
			if(choice == 1){
				key = "first_name";
			}else if (choice == 2){
				key = "last_name";
			}else if (choice == 4){
				key = "also_known_as";
			}else if (choice == 5){
				key = "moto";
			}
			query = "select * from w3d3_data where "+key+" REGEXP '"+value+"';";	// setting query for "key" and "value" matching by Regular Expression
		}
		System.out.println(connect_db(query));			// executing query
		scan.close();
	}
}
