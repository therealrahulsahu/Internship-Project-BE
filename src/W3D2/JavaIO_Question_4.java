package W3D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class InvalidCSV extends Exception{						// User-defined exception to handle error of CSV
	String mess;

	public InvalidCSV(String message){
		mess = "" + message;
	}

	public InvalidCSV(){
		mess = "CSV Contains Some Error";
	}

	@Override
	public String toString() {
		return "InvalidCSV{message= " + mess + "}";
	}
}

public class JavaIO_Question_4 {

	static ArrayList<ArrayList<String>> read_csv(String address){			// read_csv method to read csv file with return type 2D ArrayList of Strings
		ArrayList<ArrayList<String>> content = new ArrayList<>();
		try{
			File f_read = new File(address);								// Opening file
			Scanner f_scan = new Scanner(f_read);							// Initialising scanner class
			int columns = 0;
			if (f_scan.hasNextLine()) {
				String line = f_scan.nextLine();							// adding data to content variable
				String[] split_line = line.split(",");
				columns = split_line.length;								// saving length to check validity of columns
				ArrayList<String> s_line = new ArrayList<>(Arrays.asList(split_line));
				content.add(s_line);										// saving features names of CSV
			}
			int i = 1;
			while (f_scan.hasNextLine()){
				String line = f_scan.nextLine();							// adding data to content variable
				String[] split_line = line.split(",");
				if(columns != split_line.length)							// comparing number of data elements with No. of features
					throw new InvalidCSV("Inadequate Columns in Line: " + i);
				ArrayList<String> s_line = new ArrayList<>(Arrays.asList(split_line));
				content.add(s_line);										// saving data tuple of CSV
				i++;
			}
			f_scan.close();													// closing scanner
		}catch (FileNotFoundException | InvalidCSV e){
			System.out.println(e.toString());
		}
		return content;
	}

	static String table_csv(ArrayList<ArrayList<String>> content){			// function returns a formatted String in form of the table
		boolean separate = true;
		String result = "";
		for (ArrayList<String> i: content) {
			String row = "";
			for (String j : i) {
				row += String.format("%-20s", j);							// setting left alignment with width of 20
			}
			result += row + "\n";
			if(separate){													// if case to print a line between features and tuples
				String col_line = "";
				for (int j = 0; j < (i.size()+1)*20; j++) {
					col_line += "-";
				}
				result += col_line + "\n";
				separate = false;
			}
		}
		return result;
	}

	static void print_csv(ArrayList<ArrayList<String>> content){	// function prints table made of csv
		System.out.println(table_csv(content));
	}

	static void write_to_txt(ArrayList<ArrayList<String>> content, String address){		// function to write table in a file
		String data =  table_csv(content);
		try{
			FileWriter f_write = new FileWriter(address);								// Using FileWriter class to write a file
			f_write.write(data);													 	// writing to file
			f_write.close();															// closing file
		}catch (IOException e){
			System.out.println("Some Error occurred");
		}
	}

	public static void main(String[] args) {
		String read_address = "src/W3D2/Test_In.csv";
		String write_address = "src/W3D2/Test_Out_4.txt";

		ArrayList<ArrayList<String>> csv_file = read_csv(read_address);
		write_to_txt(csv_file, write_address);
	}
}
