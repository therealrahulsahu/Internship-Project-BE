import com.database.CSVReader;
import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;

import java.util.ArrayList;

public class UploadToDB {
        public static void main(String[] args) {
		long csv_start_time = System.nanoTime();

		// starting CSV Reader
        CSVReader file = new CSVReader("src/DataUploading.csv");

        // getting POJO list from CSVReader object
        ArrayList<CustomerInvoicePOJO> POJOS = file.get_ArrayList_of_POJO();

		System.out.println("CSV Read Time(ms): "+ ((System.nanoTime()-csv_start_time)/1000000));


		long db_upload_start_time = System.nanoTime();

		// Initialising MySQL Class with url, username and password
		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

		// taking batch of "step" size
		int step = 2000;
		for (int i = 0; i < 50000; i+=step) {

			// insert query is used to insert data
			String query = "insert into customer_invoice (" + POJOS.get(0).comma_separated_keys() + ") values ";
			try{
				for (CustomerInvoicePOJO x:POJOS.subList(i, i+step)) {
					query += "("+x.comma_separated_values()+"),";
				}
			}catch (IndexOutOfBoundsException e){
				for (CustomerInvoicePOJO x:POJOS.subList(i, 50000)) {
					query += "("+x.comma_separated_values()+"),";
				}
			}
			query = query.substring(0, query.length()-1);
			query+=";";
			DB.insert_query(query);
			System.out.println(i);
		}

		System.out.println("DB Upload Time(ms): "+ ((System.nanoTime()-db_upload_start_time)/1000000));
    }
}

