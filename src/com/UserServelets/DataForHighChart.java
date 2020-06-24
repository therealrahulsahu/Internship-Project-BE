package com.UserServelets;

import com.database.MySQLTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DataForHighChart", urlPatterns = {"/get_data_for_highchart"})
public class DataForHighChart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setHeader("Access-Control-Allow-Origin", "*");

		String result="";
		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");
		result = DB.getAllCustomerOpenAmount();

		PrintWriter out = response.getWriter();
		out.print(result);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}
}
