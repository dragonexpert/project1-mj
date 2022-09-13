package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/battle")
public class BattleServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");

		String player_name = "pname";
		int player_health = 75;
		String player_weapon_name = "butterknife";
		int player_weapon_dmg = 100;
		String player_armor_name = "Leather armor";
		int player_armor_def = 10;

		String enemy_name = "ename";
		String enemy_species = "spider";
		int enemy_health = 75;
		String enemy_weapon_name = "spider fang";
		int enemy_weapon_dmg = 50;
		String enemy_armor_name = "exoskeleton";
		int enemy_armor_def = 10;
		String outcome = "won";

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"Style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Vanquish Legends</h1>\r\n"
				+ "	<div id=\"centerBox\">\r\n"
				+ "		<h2>Battle</h2>\r\n"
				+ "		<p>You battled "+enemy_name+":</p>\r\n"
				+ "		<table style=\"width:100%\">\r\n"
				+ "			<tr>\r\n"
				+ "				<th><h3>Your stats:</h3></th>\r\n"
				+ "				<th><h3>Enemy stats:</h3></th>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>Name: "+player_name+"</th>\r\n"
				+ "				<th>Name: "+enemy_name+" ("+enemy_species+")</th>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>Health: "+player_health+"</th>\r\n"
				+ "				<th>Health: "+enemy_health+"</th>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>Weapon: "+player_weapon_name+" (damage: "+player_weapon_dmg+")</th>\r\n"
				+ "				<th>Weapon: "+enemy_weapon_name+" (damage: "+enemy_weapon_dmg+")</th>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<th>Armor: "+player_armor_name+" (defense: "+player_armor_def+")</th>\r\n"
				+ "				<th>Armor: "+enemy_armor_name+" (defense: "+enemy_armor_def+")</th>\r\n"
				+ "			</tr>\r\n"
				+ "		</table>\r\n"
				+ "		<hr>\r\n"
				+ "		<p>You "+outcome+" this battle </p>\r\n"
				+ "		<form action=\"game\" method=\"post\">\r\n"
				+ "			<button type=\"submit\">Return</button>\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		//RequestDispatcher rd = request.getRequestDispatcher("game");
		//rd.include(request, response);
		
	}
}
