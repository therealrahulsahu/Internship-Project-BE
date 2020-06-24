package com.UserServelets;

import com.database.MySQLTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AllOpenInvoicesQuery", urlPatterns = {"/all_open_invoices"})
public class AllOpenInvoicesQuery extends HttpServlet {
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
			alias = "open_invoices";

			String by_CN = request.getParameter("by_CN");
			if(by_CN != null){
				if(Boolean.parseBoolean(by_CN)){
					String cs_number = request.getParameter("cs_number");
					if(cs_number != null){
						query = "select count(*) as "+alias+" from customer_invoice where customer_number="+cs_number+";";
					}else {
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					}
				}else{
					String business_code = request.getParameter("business_code");
					if(business_code != null){
						query = "select count(*) as "+alias+" from customer_invoice where binary business_code=\""+business_code+"\";";
					}else {
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					}
				}
			}else{
				query = "select count(*) as "+alias+" from customer_invoice;";
			}

			result += "\"" +alias+ "\":" +DB.customSingleValueQuery(query, alias);

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
