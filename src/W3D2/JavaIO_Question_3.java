package W3D2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JavaIO_Question_3 {
	public static void main(String[] args) {
		String read_address = "src/W3D2/Test_In.txt";
		String write_address = "src/W3D2/Test_Out_3.txt";
		try{
			FileWriter f_write = new FileWriter(write_address);				// Using FileWriter class to write a file
			File f_read = new File(read_address);							// Opening file Test_In.txt
			Scanner f_scan = new Scanner(f_read);							// Initialising scanner class

			while (f_scan.hasNextLine()) {
				String line = f_scan.nextLine();							// adding data to content variable
				String[] split = line.split("[^\\w]");					// splitting lines by spaces
				for (int i=0; i < split.length; i++) {
					String first = "";
					String last = "";
					if(split[i].length() > 1){
						first = split[i].substring(0, 1).toUpperCase();
						last = split[i].substring(1).toLowerCase();
					}else if (split[i].length() == 1){
						first = split[i].toUpperCase();
					}
					split[i] =  first + last;	// Converting first letter to uppercase and rest to lowercase
				}
				line = String.join(" ", split);					// re-joining the splitted string
				f_write.write(line + "\n");							// writing to file
			}

			f_scan.close();													// closing scanner
			f_write.close();
		}catch (IOException e){
			System.out.println(e.toString());
		}
	}
}
