package W3D2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaBasics_Question_4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t;										// t for number of test cases
		while (true){								// loop to input t without error
			try{
				t = scan.nextInt();
				break;
			}catch (InputMismatchException e){
				scan.next();
			}
		}
		for (int i=0; i < t; i++){					// executing loop t times
			long data;
			try{
				data = scan.nextLong();										// Taking long variable as input
				System.out.println(data + " can be fitted in:");
				if(data >= Byte.MIN_VALUE && data <= Byte.MAX_VALUE)		// Checking Byte range
					System.out.println("* byte");
				if(data >= Short.MIN_VALUE && data <= Short.MAX_VALUE)		// Checking Short range
					System.out.println("* short");
				if(data >= Integer.MIN_VALUE && data <= Integer.MAX_VALUE)	// Checking Integer range
					System.out.println("* int");
				if(data >= Long.MIN_VALUE && data <= Long.MAX_VALUE)		// Checking Long range
					System.out.println("* long");
			}catch (InputMismatchException e){								// Catching exception when long range exceeds
				System.out.print(scan.next() + " can't be fitted anywhere.");
			}
		}
	}
}
