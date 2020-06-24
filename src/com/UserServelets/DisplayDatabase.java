package com.UserServelets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisplayDatabase", urlPatterns = {"/DisplayDatabase"})
public class DisplayDatabase extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/DBTable.jsp");
		dispatcher.include(request, response);
	}

}
