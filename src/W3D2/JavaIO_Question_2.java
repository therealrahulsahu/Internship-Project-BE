package W3D2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JavaIO_Question_2 {
	public static void main(String[] args) {
		String read_address = "src/W3D2/Test_In.txt";
		String write_address = "src/W3D2/Test_Out_2.txt";
		String content = "";												// Initialising String variable
		try{
			File f_read = new File(read_address);							// Opening file Test_In.txt
			Scanner f_scan = new Scanner(f_read);							// Initialising scanner class
			while (f_scan.hasNextLine()) {
				content += f_scan.nextLine() + "\n";						// adding data to content variable
			}
			f_scan.close();													// closing scanner
		}catch (FileNotFoundException e){
			System.out.println(e.toString());
		}

		try{
			FileWriter f_write = new FileWriter(write_address);				// Using FileWriter class to write a file
			f_write.write(content.replace(" ", ""));	 	// writing to file
			f_write.close();															// closing file
		}catch (IOException e){
			System.out.println("Some Error occurred");
		}

	}
}
