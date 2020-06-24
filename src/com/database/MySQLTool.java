package com.database;
import java.sql.*;
import java.util.ArrayList;

public class MySQLTool {
	Connection conn = null;
	Statement stmt = null;
	ResultSet result = null;
	boolean result_available = false;
	String S_driver = "com.mysql.cj.jdbc.Driver";
	String S_url = null;
	String S_user = null;
	String S_password = null;

	//constructor to store user-configuration
	public MySQLTool(String url, String user, String password){
		S_url = url;
		S_user = user;
		S_password = password;
	}

	// function execute a insert query
	public void insert_query(String query){
		result_available = false;
		try {
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
	}

	// check availability of feature
	public boolean checkKeyAvailability(String key){
		CustomerInvoicePOJO pojo = new CustomerInvoicePOJO();
		for(String s: pojo.features) {
			if (s.equals(key)) {
				return true;
			}
		}
		return false;
	}

	// Convert ResultSet to ArrayList of POJOs
	private ArrayList<CustomerInvoicePOJO> makePojoByResultSet(ResultSet search) throws SQLException {
		ArrayList<CustomerInvoicePOJO> result = new ArrayList<>();
		Integer val_int = null;
		Float val_float = null;
		String val_string = null;
		while (search.next()){
			CustomerInvoicePOJO tuple = new CustomerInvoicePOJO();
			String[] features = tuple.features;

			try{
				val_int = search.getInt(features[0]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setPk_id(null);
			}else {
				tuple.setPk_id(val_int);
			}

			try{
				val_int = search.getInt(features[1]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setAcct_doc_header_id(null);
			}else {
				tuple.setAcct_doc_header_id(val_int);
			}

			try{
				val_int = search.getInt(features[2]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setCompany_id(null);
			}else {
				tuple.setCompany_id(val_int);
			}

			try{
				val_int = search.getInt(features[3]);
			}catch (SQLException e){
				val_int = null;
			}


			if(search.wasNull()){
				tuple.setDocument_number(null);
			}else {
				tuple.setDocument_number(val_int);
			}

			try{
				val_int = search.getInt(features[4]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setDocument_number_norm(null);
			}else {
				tuple.setDocument_number_norm(val_int);
			}

			try{
				val_string = search.getString(features[5]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setBusiness_code(null);
			}else {
				tuple.setBusiness_code(val_string);
			}

			try{
				val_string = search.getString(features[6]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setCreate_year(null);
			}else {
				tuple.setCreate_year(val_string);
			}

			try{
				val_int = search.getInt(features[7]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setDocument_line_number(null);
			}else {
				tuple.setDocument_line_number(val_int);
			}

			try{
				val_string = search.getString(features[8]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDoctype(null);
			}else {
				tuple.setDoctype(val_string);
			}

			try{
				val_int = search.getInt(features[9]);
			}catch (SQLException e){
				val_int = null;
			}


			if(search.wasNull()){
				tuple.setCustomer_number(null);
			}else {
				tuple.setCustomer_number(val_int);
			}

			try{
				val_int = search.getInt(features[10]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setCustomer_number_norm(null);
			}else {
				tuple.setCustomer_number_norm(val_int);
			}

			try{
				val_int = search.getInt(features[11]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setFk_customer_map_id(null);
			}else {
				tuple.setFk_customer_map_id(val_int);
			}

			try{
				val_string = search.getString(features[12]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setCustomer_name(null);
			}else {
				tuple.setCustomer_name(val_string);
			}

			try{
				val_string = search.getString(features[13]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDivision(null);
			}else {
				tuple.setDivision(val_string);
			}

			try{
				val_string = search.getString(features[14]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDocument_create_date(null);
			}else {
				tuple.setDocument_create_date(val_string);
			}

			try{
				val_string = search.getString(features[15]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDocument_create_date_norm(null);
			}else {
				tuple.setDocument_create_date_norm(val_string);
			}

			try{
				val_string = search.getString(features[16]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setPosting_date(null);
			}else {
				tuple.setPosting_date(val_string);
			}

			try{
				val_string = search.getString(features[17]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setPosting_date_norm(null);
			}else {
				tuple.setPosting_date_norm(val_string);
			}

			try{
				val_string = search.getString(features[18]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setPosting_id(null);
			}else {
				tuple.setPosting_id(val_string);
			}

			try{
				val_string = search.getString(features[19]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDue_date(null);
			}else {
				tuple.setDue_date(val_string);
			}

			try{
				val_string = search.getString(features[20]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDue_date_norm(null);
			}else {
				tuple.setDue_date_norm(val_string);
			}

			try{
				val_string = search.getString(features[21]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setOrder_date(null);
			}else {
				tuple.setOrder_date(val_string);
			}

			try{
				val_string = search.getString(features[22]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setOrder_date_norm(null);
			}else {
				tuple.setOrder_date_norm(val_string);
			}

			try{
				val_int = search.getInt(features[23]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setInvoice_id(null);
			}else {
				tuple.setInvoice_id(val_int);
			}

			try{
				val_int = search.getInt(features[24]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setInvoice_id_norm(null);
			}else {
				tuple.setInvoice_id_norm(val_int);
			}

			try{
				val_string = search.getString(features[25]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setBaseline_create_date(null);
			}else {
				tuple.setBaseline_create_date(val_string);
			}

			try{
				val_string = search.getString(features[26]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setInvoice_date_norm(null);
			}else {
				tuple.setInvoice_date_norm(val_string);
			}

			try{
				val_float = search.getFloat(features[27]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setTotal_open_amount(null);
			}else {
				tuple.setTotal_open_amount(val_float);
			}

			try{
				val_float = search.getFloat(features[28]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setTotal_open_amount_norm(null);
			}else {
				tuple.setTotal_open_amount_norm(val_float);
			}

			try{
				val_int = search.getInt(features[29]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setCust_payment_terms(null);
			}else {
				tuple.setCust_payment_terms(val_int);
			}

			try{
				val_string = search.getString(features[30]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setBusiness_area(null);
			}else {
				tuple.setBusiness_area(val_string);
			}

			try{
				val_string = search.getString(features[31]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setShip_date(null);
			}else {
				tuple.setShip_date(val_string);
			}

			try{
				val_string = search.getString(features[32]);
			}catch (SQLException e){
				val_string = null;
			}


			if(search.wasNull()){
				tuple.setShip_to(null);
			}else {
				tuple.setShip_to(val_string);
			}

			try{
				val_string = search.getString(features[33]);
			}catch (SQLException e){
				val_string = null;
			}


			if(search.wasNull()){
				tuple.setClearing_date(null);
			}else {
				tuple.setClearing_date(val_string);
			}

			try{
				val_string = search.getString(features[34]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setClearing_date_norm(null);
			}else {
				tuple.setClearing_date_norm(val_string);
			}

			try{
				val_string = search.getString(features[35]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setReason_code(null);
			}else {
				tuple.setReason_code(val_string);
			}

			try{
				val_int = search.getInt(features[36]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setIsopen(null);
			}else {
				tuple.setIsopen(val_int);
			}

			try{
				val_string = search.getString(features[37]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDiscount_due_date_norm(null);
			}else {
				tuple.setDiscount_due_date_norm(val_string);
			}

			try{
				val_string = search.getString(features[38]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDebit_credit_indicator(null);
			}else {
				tuple.setDebit_credit_indicator(val_string);
			}

			try{
				val_string = search.getString(features[39]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setPayment_method(null);
			}else {
				tuple.setPayment_method(val_string);
			}

			try{
				val_string = search.getString(features[40]);
			}catch (SQLException e){
				val_string = null;
			}

			if(search.wasNull()){
				tuple.setDocument_creation_date(null);
			}else {
				tuple.setDocument_creation_date(val_string);
			}

			try{
				val_float = search.getFloat(features[41]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setInvoice_amount_doc_currency(null);
			}else {
				tuple.setInvoice_amount_doc_currency(val_float);
			}

			try{
				val_int = search.getInt(features[42]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setDocument_id(null);
			}else {
				tuple.setDocument_id(val_int);
			}

			try{
				val_float = search.getFloat(features[43]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setActual_open_amount(null);
			}else {
				tuple.setActual_open_amount(val_float);
			}

			try{
				val_float = search.getFloat(features[44]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setPaid_amount(null);
			}else {
				tuple.setPaid_amount(val_float);
			}

			try{
				val_int = search.getInt(features[45]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setDayspast_due(null);
			}else {
				tuple.setDayspast_due(val_int);
			}

			try{
				val_int = search.getInt(features[46]);
			}catch (SQLException e){
				val_int = null;
			}

			if(search.wasNull()){
				tuple.setInvoice_age(null);
			}else {
				tuple.setInvoice_age(val_int);
			}

			try{
				val_float = search.getFloat(features[47]);
			}catch (SQLException e){
				val_float = null;
			}

			if(search.wasNull()){
				tuple.setDisputed_amount(null);
			}else {
				tuple.setDisputed_amount(val_float);
			}

			result.add(tuple);
		}
		return result;
	}

	//select by key and values
	public ArrayList<CustomerInvoicePOJO> getByKeyValue(String key, String value){
		ArrayList<CustomerInvoicePOJO> result = new ArrayList<>();
		if(checkKeyAvailability(key)){
			try{
				Class.forName(S_driver);
				conn = DriverManager.getConnection(S_url, S_user, S_password);
				stmt = conn.createStatement();
				String query;
				if(value==null){
					query = "SELECT * FROM customer_invoice WHERE "+key+" IS NULL;";
				}else {
					query = "SELECT * FROM customer_invoice WHERE "+key+"='"+value+"';";
				}
				ResultSet resultset = stmt.executeQuery(query);
				result = makePojoByResultSet(resultset);
			} catch (Exception e){
				System.out.println(e.toString());
			} finally{
				close();
			}
		}else{
			System.out.println("Invalid Key Found");
		}
		return result;
	}

	// To get all records
	public ArrayList<CustomerInvoicePOJO> getAllData(Integer limit){
		ArrayList<CustomerInvoicePOJO> result = new ArrayList<>();
		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			String query = "SELECT * FROM customer_invoice LIMIT "+limit+";";
			ResultSet resultset = stmt.executeQuery(query);
			result = makePojoByResultSet(resultset);
		} catch (Exception e){
			System.out.println(e.toString());
		} finally{
			close();
		}
		return result;
	}

	// function to execute multiple insert queries
	public void insert_multiple_queries(ArrayList<String> queries){
		result_available = false;
		try {
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			for (String query: queries) {
				stmt.executeUpdate(query);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			close();
		}
	}

	// method to close connection
	void close(){
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException ignored){
		}
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			System.out.println(se.toString());
		}
	}

	// select query by only string
	public ArrayList<CustomerInvoicePOJO> selectQuery(String query){
		ArrayList<CustomerInvoicePOJO> result = new ArrayList<>();
		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			ResultSet resultset = stmt.executeQuery(query);
			result = makePojoByResultSet(resultset);
		} catch (Exception e){
			System.out.println(e.toString());
		} finally{
			close();
		}
		return result;
	}

	// query for single value with an alias name
	public Integer customSingleValueQuery(String query, String alias){
		Integer out = null;
		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			while (result.next()){
				out = result.getInt(alias);
			}
		} catch (Exception e){
			System.out.println(e.toString());
		} finally{
			close();
		}
		return out;
	}

	// list of customer search with total open amount by name regular expression
	public String getCustomerListByTotalOpenAmount(boolean byCsName, String nameRegex, String use_compare, int amount){
		String result = "";
		String query = "";
		if(byCsName){
			query = "select round(sum(total_open_amount)) as open_amount, customer_name, customer_number " +
					"from customer_invoice where customer_name regexp '"+
					nameRegex+"' or customer_number regexp '"+
					nameRegex+"' group by customer_name, customer_number;";
		}else {
			String cmp = "";
			if(use_compare.equals("m")) {
				cmp = ">";
			}else if(use_compare.equals("l")) {
				cmp = "<";
			}else if(use_compare.equals("me")) {
				cmp = ">=";
			}else if(use_compare.equals("le")) {
				cmp = "<=";
			}else if(use_compare.equals("ne")) {
				cmp = "!=";
			}else {
				cmp = "=";
			}
			
			query = "select * from (select round(sum(total_open_amount)) as open_amount, customer_name, " +
					"customer_number from customer_invoice group by customer_name, customer_number) as A " +
					"where A.open_amount "+cmp+" "+amount+";";
		}

		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while (set.next()){
				String tuple="{";
				tuple += "\"open_amount\":"+set.getInt("open_amount")+",";
				tuple += "\"customer_name\":\""+set.getString("customer_name")+"\",";
				tuple += "\"customer_number\":"+set.getInt("customer_number");
				tuple += "},";
				result += tuple;
			}

		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			close();
		}
		if(result.length() > 0){
			result = result.substring(0, result.length()-1);
		}
		return "["+result+"]";
	}

	// single value query by customer number
	public String getCustomerNameByNumber(int number){
		String query = "select customer_name from customer_invoice where customer_number="+number+" limit 1";
		String query2 = "select count(*) as open_invoices from customer_invoice where isopen=1 and customer_number="+number+";";
		String query3 = "select round(sum(total_open_amount)) as open_amount from customer_invoice where customer_number="+number+";";
		String result = "{";
		String tuple = "";
		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while (set.next()){
				tuple = set.getString("customer_name");
			}
			result += "\"customer_name\":\""+tuple+"\",";

			set = stmt.executeQuery(query2);
			while (set.next()){
				tuple = ""+set.getInt("open_invoices");
			}
			result += "\"open_invoices\":"+tuple+",";

			set = stmt.executeQuery(query3);
			while (set.next()){
				tuple = ""+set.getInt("open_amount");
			}
			result += "\"open_amount\":"+tuple+"";

			result += "}";
		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			close();
		}
		return result;
	}

	public String getAllCustomerOpenAmount(){
		String result = "";
		String query = "select round(sum(total_open_amount)) as open_amount, customer_number, business_code " +
				"from customer_invoice group by customer_number, business_code order by open_amount desc;";

		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while (set.next()){
				String tuple="{";
				tuple += "\"open_amount\":"+set.getInt("open_amount")+",";
				tuple += "\"customer_number\":\""+set.getString("customer_number")+"\",";
				tuple += "\"business_code\":\""+set.getString("business_code")+"\"";
				tuple += "},";
				result += tuple;
			}

		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			close();
		}
		if(result.length() > 0){
			result = result.substring(0, result.length()-1);
		}
		return "["+result+"]";
	}

	public void updateOA_DocTypeByPk_Id(String pk_id, String open_amount, String doc_type){
		String query = "update customer_invoice set total_open_amount = "+
				open_amount+", doctype='"+doc_type+"' where pk_id = "+pk_id+";";

		try{
			Class.forName(S_driver);
			conn = DriverManager.getConnection(S_url, S_user, S_password);
			stmt = conn.createStatement();

			stmt.executeUpdate(query);

		}catch (Exception e){
			System.out.println(e.toString());
		}finally {
			close();
		}
	}
}
