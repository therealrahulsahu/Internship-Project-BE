package com.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

// User-defined exception to handle error of CSV
class InvalidCSV extends Exception {
	String mess;

	public InvalidCSV(String message) {
		mess = "" + message;
	}

	public InvalidCSV() {
		mess = "CSV Contains Some Error";
	}

	@Override
	public String toString() {
		return "InvalidCSV{message= " + mess + "}";
	}
}

public class CSVReader {

	// declaring a variable to store results
	ArrayList<ArrayList<String>> csv_data;

	// read_csv method to read csv file with return type 2D ArrayList of Strings
	public CSVReader(String address){
		ArrayList<ArrayList<String>> content = new ArrayList<>();
		try{
			// Opening file
			File f_read = new File(address);
			// Initialising scanner class
			Scanner f_scan = new Scanner(f_read);
			int columns = 0;
			if (f_scan.hasNextLine()) {
				// adding data to content variable
				String line = f_scan.nextLine();
				String[] split_line = line.split(",");
				// saving length to check validity of columns
				columns = split_line.length;
				ArrayList<String> s_line = new ArrayList<>(Arrays.asList(split_line));
				// saving features names of CSV
				content.add(s_line);
			}
			int i = 1;
			while (f_scan.hasNextLine()){
				// adding data to content variable
				String line = f_scan.nextLine()+" ";
				String[] split_line = line.split(",");
				// comparing number of data elements with No. of features
				if(columns != split_line.length)
					throw new InvalidCSV("Inadequate Columns in Line: " + i);
				ArrayList<String> s_line = new ArrayList<>(Arrays.asList(split_line));
				// saving data tuple of CSV
				content.add(s_line);
				i++;
			}
			// closing scanner
			f_scan.close();
		}catch (FileNotFoundException | InvalidCSV e){
			System.out.println(e.toString());
		}
		csv_data =  content;
	}

	public ArrayList<ArrayList<String>> getArrayList(){
		// get method for csv_read
		return csv_data;
	}

	// function returns a formatted String in form of the table
	public String table_csv(){
		ArrayList<ArrayList<String>> content = csv_data;
		boolean separate = true;
		String result = "";
		for (ArrayList<String> i: content) {
			String row = "";
			for (String j : i) {
				// setting left alignment with width of 20
				row += String.format("%-20s", j);
			}
			result += row + "\n";
			// if case to print a line between features and tuples
			if(separate){
				String col_line = "";
				for (int j = 0; j < (i.size()+1)*20; j++) {
					col_line += "-";
				}
				result += col_line + "\n";
				separate = false;
			}
		}
		return result;
	}

	public void print_csv(){
		// function prints table made of csv
		System.out.println(table_csv());
	}

	public void write_to_file(String address){											// function to write table in a file
		String data =  table_csv();
		try{
			FileWriter f_write = new FileWriter(address);								// Using FileWriter class to write a file
			f_write.write(data);													 	// writing to file
			f_write.close();															// closing file
		}catch (IOException e){
			System.out.println("Some Error occurred");
		}
	}

	// function to get ArrayList fo POJO objects
	public ArrayList<CustomerInvoicePOJO> get_ArrayList_of_POJO(){

		// declaring variable to store POJO list
		ArrayList<CustomerInvoicePOJO> result = new ArrayList<>();

		// using loop from 1 to end
		for (ArrayList<String> data: csv_data.subList(1, csv_data.size())) {

			// creating a POJO object
			CustomerInvoicePOJO tuple = new CustomerInvoicePOJO();

			// setting pk_id to null
			tuple.setPk_id(null);

			// checking for empty feature and storing null into them
			if(data.get(0).equals("")){
				tuple.setAcct_doc_header_id(null);
			}else {
				tuple.setAcct_doc_header_id(Integer.parseInt(data.get(0)));
			}

			if(data.get(1).equals("")){
				tuple.setCompany_id(null);
			}else {
				tuple.setCompany_id(Integer.parseInt(data.get(1)));
			}

			if(data.get(2).equals("")){
				tuple.setDocument_number(null);
			}else {
				tuple.setDocument_number(Integer.parseInt(data.get(2)));
			}

			if (data.get(3).equals("")){
				tuple.setDocument_number_norm(null);
			}else {
				tuple.setDocument_number_norm(Integer.parseInt(data.get(3)));
			}

			if (data.get(4).equals("")){
				tuple.setBusiness_code(null);
			}else {
				tuple.setBusiness_code(data.get(4));
			}

			if (data.get(5).equals("")){
				tuple.setCreate_year(null);
			}else {
				tuple.setCreate_year(data.get(5));
			}

			if (data.get(6).equals("")){
				tuple.setDocument_line_number(null);
			}else {
				tuple.setDocument_line_number(Integer.parseInt(data.get(6)));
			}

			if (data.get(7).equals("")){
				tuple.setDoctype(null);
			}else {
				tuple.setDoctype(data.get(7));
			}

			if (data.get(8).equals("")){
				tuple.setCustomer_number(null);
			}else {
				tuple.setCustomer_number(Integer.parseInt(data.get(8)));
			}

			if (data.get(9).equals("")){
				tuple.setCustomer_number_norm(null);
			}else {
				tuple.setCustomer_number_norm(Integer.parseInt(data.get(9)));
			}

			if (data.get(10).equals("")){
				tuple.setFk_customer_map_id(null);
			}else {
				tuple.setFk_customer_map_id(Integer.parseInt(data.get(10)));
			}

			if (data.get(11).equals("")){
				tuple.setCustomer_name(null);
			}else {
				tuple.setCustomer_name(data.get(11));
			}

			if (data.get(12).equals("")){
				tuple.setDivision(null);
			}else {
				tuple.setDivision(data.get(12));
			}

			if (data.get(13).equals("")){
				tuple.setDocument_create_date(null);
			}else {
				tuple.setDocument_create_date(data.get(13));
			}

			if (data.get(14).equals("")){
				tuple.setDocument_create_date_norm(null);
			}else {
				tuple.setDocument_create_date_norm(data.get(14));
			}

			if (data.get(15).equals("")){
				tuple.setPosting_date(null);
			}else {
				tuple.setPosting_date(data.get(15));
			}

			if (data.get(16).equals("")){
				tuple.setPosting_date_norm(null);
			}else {
				tuple.setPosting_date_norm(data.get(16));
			}

			if (data.get(17).equals("")){
				tuple.setPosting_id(null);
			}else {
				tuple.setPosting_id(data.get(17));
			}

			if (data.get(18).equals("")){
				tuple.setDue_date(null);
			}else {
				tuple.setDue_date(data.get(18));
			}

			if (data.get(19).equals("")){
				tuple.setDue_date_norm(null);
			}else {
				tuple.setDue_date_norm(data.get(19));
			}

			if (data.get(20).equals("")){
				tuple.setOrder_date(null);
			}else {
				tuple.setOrder_date(data.get(20));
			}

			if (data.get(21).equals("")){
				tuple.setOrder_date_norm(null);
			}else {
				tuple.setOrder_date_norm(data.get(21));
			}

			if (data.get(22).equals("")){
				tuple.setInvoice_id(null);
			}else {
				tuple.setInvoice_id(Integer.parseInt(data.get(22)));
			}

			if (data.get(23).equals("")){
				tuple.setInvoice_id_norm(null);
			}else {
				tuple.setInvoice_id_norm(Integer.parseInt(data.get(23)));
			}

			if (data.get(24).equals("")){
				tuple.setBaseline_create_date(null);
			}else {
				tuple.setBaseline_create_date(data.get(24));
			}

			if (data.get(25).equals("")){
				tuple.setInvoice_date_norm(null);
			}else {
				tuple.setInvoice_date_norm(data.get(25));
			}

			if (data.get(26).equals("")){
				tuple.setTotal_open_amount(null);
			}else {
				tuple.setTotal_open_amount(Float.parseFloat(data.get(26)));
			}

			if (data.get(27).equals("")){
				tuple.setTotal_open_amount_norm(null);
			}else {
				tuple.setTotal_open_amount_norm(Float.parseFloat(data.get(27)));
			}

			if (data.get(28).equals("")){
				tuple.setCust_payment_terms(null);
			}else {
				tuple.setCust_payment_terms(Integer.parseInt(data.get(28)));
			}

			if (data.get(29).equals("")){
				tuple.setBusiness_area(null);
			}else {
				tuple.setBusiness_area(data.get(29));
			}

			if (data.get(30).equals("")){
				tuple.setShip_date(null);
			}else {

				// ship_date have date in 2 format and it needs to be parsed before saving
				String ship = data.get(30);

				ship = parseDate_mm_dd_yyyy(ship);

				// getting year from date
				int year  = Integer.parseInt(ship.substring(6));

				// some of year value is in 3 digit
				if(year<2000){
					// so it was replaced by baseline_create_date
					tuple.setShip_date(tuple.getBaseline_create_date());
				}else{
					tuple.setShip_date(ship);
				}
			}

			if (data.get(31).equals("")){
				tuple.setShip_to(null);
			}else {
				tuple.setShip_to(data.get(31));
			}

			if (data.get(32).equals("")){
				tuple.setClearing_date(null);
			}else {
				tuple.setClearing_date(data.get(32));
			}

			if (data.get(33).equals("")){
				tuple.setClearing_date_norm(null);
			}else {
				tuple.setClearing_date_norm(data.get(33));
			}

			if (data.get(34).equals("")){
				tuple.setReason_code(null);
			}else {
				tuple.setReason_code(data.get(34));
			}

			if (data.get(35).equals("")){
				tuple.setIsopen(null);
			}else {
				tuple.setIsopen(Integer.parseInt(data.get(35)));
			}

			if (data.get(36).equals("")){
				tuple.setDiscount_due_date_norm(null);
			}else {
				tuple.setDiscount_due_date_norm(data.get(36));
			}

			if (data.get(37).equals("")){
				tuple.setDebit_credit_indicator(null);
			}else {
				tuple.setDebit_credit_indicator(data.get(37));
			}

			if (data.get(38).equals("")){
				tuple.setPayment_method(null);
			}else {
				tuple.setPayment_method(data.get(38));
			}

			if (data.get(39).equals("")){
				tuple.setDocument_creation_date(null);
			}else {
				tuple.setDocument_creation_date(data.get(39));
			}

			if (data.get(40).equals("")){
				tuple.setInvoice_amount_doc_currency(null);
			}else {
				tuple.setInvoice_amount_doc_currency(Float.parseFloat(data.get(40)));
			}

			if (data.get(41).equals("")){
				tuple.setDocument_id(null);
			}else {
				tuple.setDocument_id(Integer.parseInt(data.get(41)));
			}

			if (data.get(42).equals("")){
				tuple.setActual_open_amount(null);
			}else {
				tuple.setActual_open_amount(Float.parseFloat(data.get(42)));
			}

			if (data.get(43).equals("")){
				tuple.setPaid_amount(null);
			}else {
				tuple.setPaid_amount(Float.parseFloat(data.get(43)));
			}

			if (data.get(44).equals("")){
				tuple.setDayspast_due(null);
			}else {
				tuple.setDayspast_due(Integer.parseInt(data.get(44)));
			}

			if (data.get(45).equals("")){
				tuple.setInvoice_age(null);
			}else {
				tuple.setInvoice_age(Integer.parseInt(data.get(45)));
			}

			if (data.get(46).equals("") || data.get(46).equals(" ")){
				tuple.setDisputed_amount(null);
			}else {
				tuple.setDisputed_amount(Float.parseFloat(data.get(46).substring(0, data.get(46).length()-1)));
			}

			result.add(tuple);
		}
		return result;
	}

	private String parseDate_mm_dd_yyyy(String value){
		// MM/dd/yyyy format is given
		SimpleDateFormat mm_dd_yyyy_1 = new SimpleDateFormat("MM/dd/yyyy");

		// MM-dd-yyyy format is given
		SimpleDateFormat mm_dd_yyyy_2 = new SimpleDateFormat("MM-dd-yyyy");

		//declaring date variable to hold parsed date
		Date d = new Date();
		try{

			// first parser is used
			d = mm_dd_yyyy_1.parse(value);
		}catch (Exception e){

			// this is used to handle
			try {
				d = mm_dd_yyyy_2.parse(value);
			}catch (Exception es){}
		}

		return ""+d.getDay()+"-"+d.getMonth()+"-"+d.getYear();
	}
}
