package com.UserServelets;

import com.database.CustomerInvoicePOJO;
import com.database.MySQLTool;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CardsQuery", urlPatterns = {"/card_details"})
public class CardsQuery extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		try{
			MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");
			String result = "{";
			String alias = "";
			String query = "";
			String business_code = request.getParameter("business_code");
			if(business_code == null){
				alias = "total_customer";
				query = "select count(distinct customer_number) as "+alias+" from customer_invoice;";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "total_open_ar";
				query = "select round(sum(total_open_amount)) as "+alias+" from customer_invoice;";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "average_days_delay";
				query = "select round(avg(dayspast_due)) as "+alias+" from customer_invoice;";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "total_open_invoices";
				query = "select count(customer_number) as "+alias+" from customer_invoice where isopen=1;";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\"";
			}else{
				alias = "total_customer";
				query = "select count(distinct customer_number) as "+alias+" from customer_invoice where binary business_code=\""+business_code+"\";";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "total_open_ar";
				query = "select round(sum(total_open_amount)) as "+alias+" from customer_invoice where binary business_code=\""+business_code+"\";";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "average_days_delay";
				query = "select round(avg(dayspast_due)) as "+alias+" from customer_invoice where binary business_code=\""+business_code+"\";";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\",";

				alias = "total_open_invoices";
				query = "select count(customer_number) as "+alias+" from customer_invoice where isopen=1 and business_code=\""+business_code+"\";";
				result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\"";
			}

			result += "}";

			PrintWriter out = response.getWriter();
			out.print(result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}catch (NumberFormatException e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
