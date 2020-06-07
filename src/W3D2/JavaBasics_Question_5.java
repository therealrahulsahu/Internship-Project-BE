package W3D2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaBasics_Question_5 {
	static String series(int a, int b, int n){				// method to compute series
		String result = "";
		for (int i = 0; i < n; i++) {						// loop for outer series
			int step = a;
			for (int j = 0; j < i+1; j++) {					// loop for inner series
				step += Math.pow(2, j) * b;
			}
			result += step + " ";
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q;										// t for number of test cases
		while (true){								// loop to input t without error
			try{
				q = scan.nextInt();
				break;
			}catch (InputMismatchException e){
				scan.next();
			}
		}
		int[][] data = new int[q][3];								// Declaring 2D array of qx3 to store input
		for (int i=0; i < q;){										// executing loop too take q user input
			try{
				String sub = scan.nextLine();
				String[] sub_arr = sub.split("\\s");			// splitting input by spaces
				for(int j=0;j<3;j++)
				{
					data[i][j]=Integer.parseInt(sub_arr[j]);		// parsing all integers
				}
				i++;
			}catch (NumberFormatException | ArrayIndexOutOfBoundsException e){}		// catching probable exception
		}
		for (int i = 0; i < q; i++) {
			System.out.println(series(data[i][0], data[i][1], data[i][2]));		// calling series function
		}
	}
}
