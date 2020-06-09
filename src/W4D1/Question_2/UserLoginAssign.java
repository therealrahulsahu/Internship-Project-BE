// Its a servlet class

package W4D1.Question_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserLoginAssign
 */
@WebServlet(description = "used in assigment of W4D1", urlPatterns = { "/UserLoginAssign" })
public class UserLoginAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserLoginAssign() {
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		if(email.equals("rahul@gmail.com") && password.equals("rahul")) {
			writer.println("<h2>You are logged in</h2>");
		}else {
			writer.println("<h2>Sorry Wrong Password</h2>");
		}
		writer.close();
		
	}

}
