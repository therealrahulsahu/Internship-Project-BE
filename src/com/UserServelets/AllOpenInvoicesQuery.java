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
			try{
				int cs_number = Integer.parseInt(request.getParameter("cs_number"));
				query = "select count(*) as "+alias+" from customer_invoice where isopen=1 and customer_number="+cs_number+";";
			}catch (Exception e){
				query = "select count(*) as "+alias+" from customer_invoice where isopen=1;";
			}

			result += "\"" +alias+ "\":\"" +DB.customSingleValueQuery(query, alias)+"\"";

			result += "}";

			PrintWriter out = response.getWriter();
			out.print(result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}catch (NumberFormatException e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
