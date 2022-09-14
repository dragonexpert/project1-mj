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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{


	
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
					
				     QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.User");
				     queryBuilder = queryBuilder.getColumns("*").fromTable("game_user").where("username", username, "=");
				     User user = (User) queryBuilder.getOne(); 
				    if(pass1.equals(user.getPassword())) {	
				    
			        QueryBuilder queryBuilder5 = new QueryBuilder(connection, "repository.User");
			        queryBuilder5.deleteTable("game_user").where("username", username, "=").executeOperation();
			        
			        QueryBuilder queryBuilder6 = new QueryBuilder(connection, "repository.Characters");
			        queryBuilder6.deleteTable("character_sheet").where("name", username, "=").executeOperation();
			}
			  
				//Insert into users username and password
				//Create a corresponding game character
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
				}
			else {
				//Create failed, reload the page
				RequestDispatcher rd = request.getRequestDispatcher("/delete.html");
				rd.forward(request, response);
			}
		}
	}
