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

@WebServlet(name = "FetchListOfPeople", urlPatterns = {"/user_open_invoice_fetch_by_limit_and_offset"})
public class FetchListOfPeople extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		try{
			int limit = Integer.parseInt(request.getParameter("limit"));
			int offset = Integer.parseInt(request.getParameter("offset"));
			String query;

			MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

			try{
				int cs_number = Integer.parseInt(request.getParameter("cs_number"));
				query = "select * from customer_invoice where isopen=1 and customer_number="+cs_number+" limit "+limit+" offset "+offset+";";
			}catch (Exception e){
				query = "select * from customer_invoice where isopen=1 limit "+limit+" offset "+offset+";";
			}

			ArrayList<CustomerInvoicePOJO> result = DB.selectQuery(query);

			Gson gson = new Gson();
			String element = gson.toJson(result, new TypeToken<ArrayList<CustomerInvoicePOJO>>() {}.getType());

			PrintWriter out = response.getWriter();
			out.print(element);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}catch (NumberFormatException e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
