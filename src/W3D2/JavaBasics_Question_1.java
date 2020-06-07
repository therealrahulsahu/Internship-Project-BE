package W3D2;
import java.util.Scanner;

class Arithmetic{
    int add(int a, int b){                              // method add is declared
        return a+b;
    }
}

class Addr extends Arithmetic{                          // Class Addr is declared with inheriting Arithmetic Class
}

public class JavaBasics_Question_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);			// Scanner class object is created to take user input
		int a, b;
		while (true){									// Using loop to get valid input
			try{
				String sub = scan.nextLine();
				String[] sub_arr = sub.split("\\s");	// split input by space
				a = Integer.parseInt(sub_arr[0]);		// parsing first digit to integer
				b = Integer.parseInt(sub_arr[1]);		// parsing second digit to integer
				break;									// breaking loop after successful input
			}catch (NumberFormatException | ArrayIndexOutOfBoundsException e){}	// catching probable Exception
		}

        Addr obj = new Addr();							// Creating object of Addr class
        System.out.println(obj.add(a,b));				// calling "add" method of object "obj"
    }
}
