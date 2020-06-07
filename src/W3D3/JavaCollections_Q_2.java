package W3D3;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaCollections_Q_2 {
	public static void main(String[] args) {
		ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 4, 9, 0, -3, -4, 34, -56));		// Creating ArrayList

		data.add(4, 6);		// adding 6 at index 4
		data.add(2, 56);	// adding 56 at index 2

		System.out.println(data);			// printing ArrayList
	}
}
