package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ConnectionFactory;
import controller.QueryBuilder;
import repository.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	Connection connection;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ConnectionFactory connectionFactory = new ConnectionFactory("java-angular-82322.cqrfh5fisbnz.us-west-1.rds.amazonaws.com", "postgres", 5432, "postgres", "password123");
        Connection connection = connectionFactory.createNewConnection();
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		 QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.User");
	        queryBuilder.getColumns("*").fromTable("game_user");
	        queryBuilder.viewSQL();
	        ArrayList<Object> userList;
	        userList = queryBuilder.executeQuery();
	        System.out.println("Rows: " + userList.size());
	        System.out.println(userList.toString());
	        System.out.println("\n\n\n");
	        
		//Replace with verifying the username
		if(username.equals("user")) {
			System.out.println("Successful login");
			RequestDispatcher rd = request.getRequestDispatcher("game");
			rd.forward(request, response);
		} else {
			System.out.println("Failed login");
			//out.println("Username or password is incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}
}
