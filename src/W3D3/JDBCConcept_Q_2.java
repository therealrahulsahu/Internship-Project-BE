package W3D3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

class UserPOJO{													// POJO class for database table
	private Integer serial_number;								// Using Integer to avoid null value error
	private String first_name, last_name, also_known_as, moto;

	public Integer getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(Integer serial_number) {
		this.serial_number = serial_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAlso_known_as() {
		return also_known_as;
	}

	public void setAlso_known_as(String also_known_as) {
		this.also_known_as = also_known_as;
	}

	public String getMoto() {
		return moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

}

public class JDBCConcept_Q_2 {
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

	static ArrayList<UserPOJO> connect_db(String query){						// method to execute given query
		ArrayList<UserPOJO> result = new ArrayList<>();        	// String to store result

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
			while(rs.next()){											// using iterator and fetching data
				UserPOJO tuple = new UserPOJO();
				Integer serial_number  = rs.getInt("serial_number");
				if(rs.wasNull()){										// checking for null values
					serial_number = null;
				}
				String first_name = rs.getString("first_name");
				if(rs.wasNull()){
					first_name = null;
				}
				String last_name = rs.getString("last_name");
				if(rs.wasNull()){
					last_name = null;
				}
				String also_known_as = rs.getString("also_known_as");
				if(rs.wasNull()){
					also_known_as = null;
				}
				String moto = rs.getString("moto");
				if(rs.wasNull()){
					moto = null;
				}

				tuple.setFirst_name(first_name);
				tuple.setLast_name(last_name);
				tuple.setSerial_number(serial_number);
				tuple.setAlso_known_as(also_known_as);
				tuple.setMoto(moto);

				result.add(tuple);								// adding UserPOJO to result
			}
			rs.close();
		} catch(Exception se){
			System.out.println(se.toString());
		} finally{									// closing opened connection
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException ignored){
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

	static void print_POJOS(ArrayList<UserPOJO> data){
		for (UserPOJO x: data) {
			String result = "";

			result += "  First Name: ";
			if(x.getFirst_name() != null){
				result += x.getFirst_name();
			}
			result += "  Last Name: ";
			if (x.getLast_name() != null){
				result += x.getLast_name();
			}
			result += "  Serial: ";
			if (x.getSerial_number() != null){
				result += x.getSerial_number();
			}
			result += "  Alias: ";
			if (x.getAlso_known_as() != null){
				result += x.getAlso_known_as();
			}
			result += "  Quote: ";
			if (x.getMoto() != null){
				result += x.getMoto();
			}
			System.out.println(result);
		}
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
		ArrayList<UserPOJO> retrieve = connect_db(query);			// executing query
		print_POJOS(retrieve);
		scan.close();
	}
}
