package com.database;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class MySQLTool {
	Connection conn = null;
	Statement stmt = null;
	ResultSet result = null;
	boolean result_available = false;
	String S_driver = "com.mysql.cj.jdbc.Driver";
	String S_url = "jdbc:mysql://localhost:3306/project";
	String S_user = "root";
	String S_password = "";

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

			val_int = search.getInt(features[0]);
			if(search.wasNull()){
				tuple.setPk_id(null);
			}else {
				tuple.setPk_id(val_int);
			}

			val_int = search.getInt(features[1]);
			if(search.wasNull()){
				tuple.setAcct_doc_header_id(null);
			}else {
				tuple.setAcct_doc_header_id(val_int);
			}

			val_int = search.getInt(features[2]);
			if(search.wasNull()){
				tuple.setCompany_id(null);
			}else {
				tuple.setCompany_id(val_int);
			}

			val_int = search.getInt(features[3]);
			if(search.wasNull()){
				tuple.setDocument_number(null);
			}else {
				tuple.setDocument_number(val_int);
			}

			val_int = search.getInt(features[4]);
			if(search.wasNull()){
				tuple.setDocument_number_norm(null);
			}else {
				tuple.setDocument_number_norm(val_int);
			}

			val_string = search.getString(features[5]);
			if(search.wasNull()){
				tuple.setBusiness_code(null);
			}else {
				tuple.setBusiness_code(val_string);
			}

			val_string = search.getString(features[6]);
			if(search.wasNull()){
				tuple.setCreate_year(null);
			}else {
				tuple.setCreate_year(val_string);
			}

			val_int = search.getInt(features[7]);
			if(search.wasNull()){
				tuple.setDocument_line_number(null);
			}else {
				tuple.setDocument_line_number(val_int);
			}

			val_string = search.getString(features[8]);
			if(search.wasNull()){
				tuple.setDoctype(null);
			}else {
				tuple.setDoctype(val_string);
			}

			val_int = search.getInt(features[9]);
			if(search.wasNull()){
				tuple.setCustomer_number(null);
			}else {
				tuple.setCustomer_number(val_int);
			}

			val_int = search.getInt(features[10]);
			if(search.wasNull()){
				tuple.setCustomer_number_norm(null);
			}else {
				tuple.setCustomer_number_norm(val_int);
			}

			val_int = search.getInt(features[11]);
			if(search.wasNull()){
				tuple.setFk_customer_map_id(null);
			}else {
				tuple.setFk_customer_map_id(val_int);
			}

			val_string = search.getString(features[12]);
			if(search.wasNull()){
				tuple.setCustomer_name(null);
			}else {
				tuple.setCustomer_name(val_string);
			}

			val_string = search.getString(features[13]);
			if(search.wasNull()){
				tuple.setDivision(null);
			}else {
				tuple.setDivision(val_string);
			}

			val_string = search.getString(features[14]);
			if(search.wasNull()){
				tuple.setDocument_create_date(null);
			}else {
				tuple.setDocument_create_date(val_string);
			}

			val_string = search.getString(features[15]);
			if(search.wasNull()){
				tuple.setDocument_create_date_norm(null);
			}else {
				tuple.setDocument_create_date_norm(val_string);
			}

			val_string = search.getString(features[16]);
			if(search.wasNull()){
				tuple.setPosting_date(null);
			}else {
				tuple.setPosting_date(val_string);
			}

			val_string = search.getString(features[17]);
			if(search.wasNull()){
				tuple.setPosting_date_norm(null);
			}else {
				tuple.setPosting_date_norm(val_string);
			}

			val_string = search.getString(features[18]);
			if(search.wasNull()){
				tuple.setPosting_id(null);
			}else {
				tuple.setPosting_id(val_string);
			}

			val_string = search.getString(features[19]);
			if(search.wasNull()){
				tuple.setDue_date(null);
			}else {
				tuple.setDue_date(val_string);
			}

			val_string = search.getString(features[20]);
			if(search.wasNull()){
				tuple.setDue_date_norm(null);
			}else {
				tuple.setDue_date_norm(val_string);
			}

			val_string = search.getString(features[21]);
			if(search.wasNull()){
				tuple.setOrder_date(null);
			}else {
				tuple.setOrder_date(val_string);
			}

			val_string = search.getString(features[22]);
			if(search.wasNull()){
				tuple.setOrder_date_norm(null);
			}else {
				tuple.setOrder_date_norm(val_string);
			}

			val_int = search.getInt(features[23]);
			if(search.wasNull()){
				tuple.setInvoice_id(null);
			}else {
				tuple.setInvoice_id(val_int);
			}

			val_int = search.getInt(features[24]);
			if(search.wasNull()){
				tuple.setInvoice_id_norm(null);
			}else {
				tuple.setInvoice_id_norm(val_int);
			}

			val_string = search.getString(features[25]);
			if(search.wasNull()){
				tuple.setBaseline_create_date(null);
			}else {
				tuple.setBaseline_create_date(val_string);
			}

			val_string = search.getString(features[26]);
			if(search.wasNull()){
				tuple.setInvoice_date_norm(null);
			}else {
				tuple.setInvoice_date_norm(val_string);
			}

			val_float = search.getFloat(features[27]);
			if(search.wasNull()){
				tuple.setTotal_open_amount(null);
			}else {
				tuple.setTotal_open_amount(val_float);
			}

			val_float = search.getFloat(features[28]);
			if(search.wasNull()){
				tuple.setTotal_open_amount_norm(null);
			}else {
				tuple.setTotal_open_amount_norm(val_float);
			}

			val_int = search.getInt(features[29]);
			if(search.wasNull()){
				tuple.setCust_payment_terms(null);
			}else {
				tuple.setCust_payment_terms(val_int);
			}

			val_string = search.getString(features[30]);
			if(search.wasNull()){
				tuple.setBusiness_area(null);
			}else {
				tuple.setBusiness_area(val_string);
			}

			val_string = search.getString(features[31]);
			if(search.wasNull()){
				tuple.setShip_date(null);
			}else {
				tuple.setShip_date(val_string);
			}

			val_string = search.getString(features[32]);
			if(search.wasNull()){
				tuple.setShip_to(null);
			}else {
				tuple.setShip_to(val_string);
			}

			val_string = search.getString(features[33]);
			if(search.wasNull()){
				tuple.setClearing_date(null);
			}else {
				tuple.setClearing_date(val_string);
			}

			val_string = search.getString(features[34]);
			if(search.wasNull()){
				tuple.setClearing_date_norm(null);
			}else {
				tuple.setClearing_date_norm(val_string);
			}

			val_string = search.getString(features[35]);
			if(search.wasNull()){
				tuple.setReason_code(null);
			}else {
				tuple.setReason_code(val_string);
			}

			val_int = search.getInt(features[36]);
			if(search.wasNull()){
				tuple.setIsopen(null);
			}else {
				tuple.setIsopen(val_int);
			}

			val_string = search.getString(features[37]);
			if(search.wasNull()){
				tuple.setDiscount_due_date_norm(null);
			}else {
				tuple.setDiscount_due_date_norm(val_string);
			}

			val_string = search.getString(features[38]);
			if(search.wasNull()){
				tuple.setDebit_credit_indicator(null);
			}else {
				tuple.setDebit_credit_indicator(val_string);
			}

			val_string = search.getString(features[39]);
			if(search.wasNull()){
				tuple.setPayment_method(null);
			}else {
				tuple.setPayment_method(val_string);
			}

			val_string = search.getString(features[40]);
			if(search.wasNull()){
				tuple.setDocument_creation_date(null);
			}else {
				tuple.setDocument_creation_date(val_string);
			}

			val_float = search.getFloat(features[41]);
			if(search.wasNull()){
				tuple.setInvoice_amount_doc_currency(null);
			}else {
				tuple.setInvoice_amount_doc_currency(val_float);
			}

			val_int = search.getInt(features[42]);
			if(search.wasNull()){
				tuple.setDocument_id(null);
			}else {
				tuple.setDocument_id(val_int);
			}

			val_float = search.getFloat(features[43]);
			if(search.wasNull()){
				tuple.setActual_open_amount(null);
			}else {
				tuple.setActual_open_amount(val_float);
			}

			val_float = search.getFloat(features[44]);
			if(search.wasNull()){
				tuple.setPaid_amount(null);
			}else {
				tuple.setPaid_amount(val_float);
			}

			val_int = search.getInt(features[45]);
			if(search.wasNull()){
				tuple.setDayspast_due(null);
			}else {
				tuple.setDayspast_due(val_int);
			}

			val_int = search.getInt(features[46]);
			if(search.wasNull()){
				tuple.setInvoice_age(null);
			}else {
				tuple.setInvoice_age(val_int);
			}

			val_float = search.getFloat(features[47]);
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
}
