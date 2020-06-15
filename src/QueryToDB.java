import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class QueryToDB {
	public static void main(String[] args) {

		// Initialising MySQL Class with url, username and password
		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

		//ArrayList<CustomerInvoicePOJO> searched = DB.getByKeyValue("clearing_date", null);
		ArrayList<CustomerInvoicePOJO> searched = DB.selectQuery("select * from customer_invoice limit 2");
		System.out.println(searched.size());
		Gson gson = new Gson();
		String element = gson.toJson(searched, new TypeToken<ArrayList<CustomerInvoicePOJO>>() {}.getType());
		System.out.println(element);
		/*for (CustomerInvoicePOJO tuple: searched) {
			System.out.println(tuple.getAcct_doc_header_id());
		}*/
	}
}
