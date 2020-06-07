package W3D2;
import java.util.Scanner;
import java.lang.Math;

class MyCalculator{
	long power(int n, int p) throws Exception{						// Declaring method with two arguments n of int and p of int and returns long type which throws Exception
		if(n==0 && p==0){
			throw new Exception("n and p should not be zero.");		// throwing Exception with a message
		}else if(n<0 || p<0){
			throw new Exception("n or p should not be negative.");	// throwing Exception with a message
		}else{
			return (long) Math.pow(n, p);							// returning power calculated number after type conversion to long from double
		}
	}
}

public class JavaBasics_Question_3 {
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		MyCalculator cal = new MyCalculator();
		int[][] data = new int[5][2];								// Declaring 2D array of 5x2 to store input
		for (int i=0; i < 5;){										// executing loop too take 5 user input
			try{
				String sub = scan.nextLine();
				String[] sub_arr = sub.split("\\s");			// splitting input by spaces
				for(int j=0;j<2;j++)
				{
					data[i][j]=Integer.parseInt(sub_arr[j]);		// parsing both integers
				}
				i++;
			}catch (NumberFormatException | ArrayIndexOutOfBoundsException e){}		// catching probable exception
		}
		for (int i = 0; i<5;i++){
			try {
				System.out.println(cal.power(data[i][0], data[i][1]));		// calling power function
			}catch (Exception e){
				System.out.println(e.toString());							// Catching Error
			}
		}
    }
}
