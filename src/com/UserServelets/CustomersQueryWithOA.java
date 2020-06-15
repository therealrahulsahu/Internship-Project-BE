package com.UserServelets;

import com.database.MySQLTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomersQueryWithOA", urlPatterns = {"/customer_search_with_OA"})
public class CustomersQueryWithOA extends HttpServlet {
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
			String name = request.getParameter("cs_name");
			String result = DB.getCustomerListByTotalOpenAmount(name);

			PrintWriter out = response.getWriter();
			out.print(result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}catch (NumberFormatException e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
