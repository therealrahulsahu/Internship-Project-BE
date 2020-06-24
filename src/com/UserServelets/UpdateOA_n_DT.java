package com.UserServelets;

import com.database.MySQLTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateOA_n_DT", urlPatterns = {"/update_oa_dt_by_pk_id"})
public class UpdateOA_n_DT extends HttpServlet {
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
			String pk_id = request.getParameter("pk_id");
			String open_amount = request.getParameter("open_amount");
			String doc_type = request.getParameter("doc_type");

			if(pk_id == null || open_amount == null || doc_type == null){
				throw new Exception();
			}

			DB.updateOA_DocTypeByPk_Id(pk_id, open_amount, doc_type);

			String result = "{\"status\":\"success\"}";
			PrintWriter out = response.getWriter();
			out.print(result);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
		}catch (Exception e){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
