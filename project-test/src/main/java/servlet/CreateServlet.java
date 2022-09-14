package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ConnectionFactory;
import controller.QueryBuilder;
import repository.User;
import repository.Characters;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ConnectionFactory connectionFactory = new ConnectionFactory("java-angular-82322.cqrfh5fisbnz.us-west-1.rds.amazonaws.com", "postgres", 5432, "postgres", "password123");
        Connection connection = connectionFactory.createNewConnection();
		
		String username = request.getParameter("username");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		
		if(pass1.equals(pass2)) {
			try {
			      
		      QueryBuilder queryBuilder5 = new QueryBuilder(connection, "repository.User");
		     queryBuilder5.insertTable("game_user").setColumn("username", username).setColumn("password", pass1).viewSQL();
		     queryBuilder5.executeOperation(); 
		     queryBuilder5.getColumns("*").fromTable("game_user").where("username",username,"=");
		        User user = (User) queryBuilder5.getOne();
		        System.out.println("\n\n\n");
		     int character_id = user.getUser_id();
		     
		     QueryBuilder queryBuilder4 = new QueryBuilder(connection, "repository.Characters");
		     queryBuilder4.insertTable("character_sheet").setColumn("name", username).setColumn("gold", 0).setColumn("weapon_id", 4).setColumn("armor_id", 4).setColumn("health", 8).setColumn("user_id", character_id).executeOperation();
		     QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.Characters");
		       
		  
			//Insert into users username and password
			//Create a corresponding game character
			RequestDispatcher rd = request.getRequestDispatcher("/login");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
			}
		else {
			//Create failed, reload the page
			RequestDispatcher rd = request.getRequestDispatcher("/create.html");
			rd.forward(request, response);
		}
	}
}
