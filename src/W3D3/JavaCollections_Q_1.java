package W3D3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaCollections_Q_1 {
	static HashMap<Integer, String> map = new HashMap<>();				// Initialising HashMap

	public static String sort_by_key()
	{
		String result = "";
		TreeMap<Integer, String> t_map = new TreeMap<>(map);			// Initialising TreeMap to sort values
		for (Map.Entry<Integer, String> entry : t_map.entrySet()){		// Iterating on TreeMap
			result += ("Key: "+entry.getKey()+"  Value: "+entry.getValue() + "\n");		// Appending on output variable
		}
		return result;
	}

	public static void main(String[] args) {
		map.put(1, "G");							// adding elements in HashMap
		map.put(-5, "K");
		map.put(78, "Y");
		map.put(4, "T");
		map.put(2, "R");
		map.put(8, "T");
		System.out.println(sort_by_key());			// printing sorted result
	}
}
