package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game")
public class GameServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//response.sendRedirect("game.html");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String userWeapon = "Sturdy stick";
		int userGold = 555;
		int userHealth = 75;
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"Style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Vanquish Legends</h1>\r\n"
				+ "	<div id=\"centerBox\" style=\"width:max; padding: 20px;\">\r\n"
				+ "		<h2>Inventory:</h2>\r\n"
				+ "		<p>Weapon: "+userWeapon+"</p>\r\n"
				+ "		<p>Gold: "+userGold+"</p>\r\n"
				+ "		<p>Health: "+userHealth+"</p>\r\n"
				+ "		<hr>\r\n"
				+ "		<h2>Scavenge for Gold:</h2>\r\n"
				+ " 	<div style=\"width:max-content; margin:auto; overflow:hidden;\">"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Grass Plains</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Ancient Cave</button>\r\n"
				+ "			</form>\r\n"
				+ "			<form action=\"scavenge\" method=\"post\" style=\"width: max-content; float:left; margin:5px;\">\r\n"
				+ "				<button type=\"submit\">Flaming Battlefield</button>\r\n"
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
		System.out.println(request.getParameter("username"));
	}
}
