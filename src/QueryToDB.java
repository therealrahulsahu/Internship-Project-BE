import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;

import java.util.ArrayList;

public class QueryToDB {
	public static void main(String[] args) {

		// Initialising MySQL Class with url, username and password
		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

		//ArrayList<CustomerInvoicePOJO> searched = DB.getByKeyValue("clearing_date", null);
		ArrayList<CustomerInvoicePOJO> searched = DB.getAllData(50);
		System.out.println(searched.size());
		/*for (CustomerInvoicePOJO tuple: searched) {
			System.out.println(tuple.getAcct_doc_header_id());
		}*/
	}
}
