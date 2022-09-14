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
import repository.Characters;

@WebServlet("/game")
public class GameServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//response.sendRedirect("game.html");
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		
		ConnectionFactory connectionFactory = new ConnectionFactory("java-angular-82322.cqrfh5fisbnz.us-west-1.rds.amazonaws.com", "postgres", 5432, "postgres", "password123");
        Connection connection = connectionFactory.createNewConnection();
        
	     QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.Characters");
	        queryBuilder = queryBuilder.getColumns("*").fromTable("character_sheet").where("name", username, "=");
	        queryBuilder.viewSQL();
	        Characters characters = (Characters) queryBuilder.getOne();
	        System.out.println("\n\n\n");

		//String userWeapon = "Sturdy stick";
		int userGold = characters.getGold();
		System.out.println(characters.toString());
		int userHealth = characters.getHealth();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"Style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Vanquish Legends</h1>\r\n"
				+ "	<div id=\"centerBox\" style=\"width:max; padding: 20px;\">\r\n"
				+ "		<h2>Inventory:</h2>\r\n"
//				+ "		<p>Weapon: "+userWeapon+"</p>\r\n"
				+ "		<p>Gold: "+userGold+"</p>\r\n"
				+ "		<p>Health: "+userHealth+"</p>\r\n"
				+ "		<hr>\r\n"
				+ "		<h2>Scavenge for Gold:</h2>\r\n"
				+ " 	<div style=\"width:max-content; margin:auto; overflow:hidden;\">"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+"		<input type=\"hidden\" name=\"username\" value=\"" + username + "\" >"
				+ "				<button type=\"submit\">Grass Plains</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Ancient Cave</button>\r\n"
				+"		<input type=\"hidden\" name=\"username\" value=\"" + username + "\" >"
				+ "			</form>\r\n"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Flaming Battlefield</button>\r\n"
				+"		<input type=\"hidden\" name=\"username\" value=\"" + username + "\" >"
				+ "			</form>\r\n"
				+ " 	</div>"
				+ " 	<br>"
				+ "		<hr>\r\n"
				+ "		<h2>Other Actions</h2>\r\n"
				+ " 	<div style=\"width:max-content; margin:auto; overflow:hidden;\">"
				+ "			<form action=\"shop\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Go to Shop</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action=\"battle\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Battle Enemies</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action=\"history\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Battle History</button>\r\n"
				+ "			</form>\r\n"
				+ " 	</div>"
				+ " 	<br>"
				+ "		<hr>\r\n"
				+ "		<form action=\"index.html\" method=\"post\">\r\n"
				+ "			<button type=\"submit\">Log Out</button>\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
