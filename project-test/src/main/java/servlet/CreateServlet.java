package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		//Also make sure username is unique
		if(pass1.equals(pass2)) {
			//Insert into users username and password
			//Create a corresponding game character
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);
		}
		else {
			//Create failed, reload the page
			RequestDispatcher rd = request.getRequestDispatcher("/create.html");
			rd.forward(request, response);
		}
	}
}
