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

		int limit = 0, offset = 0;

		String limit_p = request.getParameter("limit");
		String offset_p = request.getParameter("offset");
		if(limit_p == null || offset_p == null){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}else {
			try{
				limit = Integer.parseInt(limit_p);
				offset = Integer.parseInt(offset_p);
			}catch (Exception e){
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		}

		String query="";

		MySQLTool DB = new MySQLTool("jdbc:mysql://localhost:3306/project", "root", "root");

		String by_CN = request.getParameter("by_CN");
		if(by_CN != null){
			if(Boolean.parseBoolean(by_CN)){
				String cs_number = request.getParameter("cs_number");
				if(cs_number != null){
					query = "select * from customer_invoice where customer_number="+cs_number+" order by clearing_date limit "+limit+" offset "+offset+";";
				}else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				}
			}else{
				String business_code = request.getParameter("business_code");
				if(business_code != null){
					query = "select * from customer_invoice where binary business_code=\""+business_code+"\" order by clearing_date limit "+limit+" offset "+offset+";";
				}else {
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				}
			}
		}else {
			query = "select * from customer_invoice order by clearing_date limit "+limit+" offset "+offset+";";
		}

		ArrayList<CustomerInvoicePOJO> result = DB.selectQuery(query);

		Gson gson = new Gson();
		String element = gson.toJson(result, new TypeToken<ArrayList<CustomerInvoicePOJO>>() {}.getType());

		PrintWriter out = response.getWriter();
		out.print(element);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

	}

}
