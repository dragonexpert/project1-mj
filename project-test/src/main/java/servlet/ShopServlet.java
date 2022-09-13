package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		
		String[] weaponNames = {"Copper Axe", "Iron Axe", "Steel Axe", "Diamond Axe"};
		String[] armorNames = {"Copper Armor", "Iron Armor", "Steel Armor", "Diamond Armor"};
		int[] weaponCosts = {20, 50, 100, 150};
		int[] armorCosts = {50, 100, 150, 200};
		
		String weaponsSection = "";
		for(int a = 0; a < weaponNames.length; a ++) {
			weaponsSection += "<tr><th>"+weaponNames[a]+"</th><th>"+weaponCosts[a]+"</th><th><button>Buy</button></th></tr>\r\n";
		}
		String armorSection = "";
		for(int a = 0; a < armorNames.length; a ++) {
			armorSection += "<tr><th>"+armorNames[a]+"</th><th>"+armorCosts[a]+"</th><th><button>Buy</button></th></tr>\r\n";
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"Style.css\">\r\n"
				+ "	<script>\r\n"
				+ "		function showWeapons(){\r\n"
				+ "			document.getElementById(\"WeaponsDiv\").style = \"\";\r\n"
				+ "			document.getElementById(\"ArmorDiv\").style = \"display:none;\";\r\n"
				+ "		}\r\n"
				+ "		function showArmor(){\r\n"
				+ "			document.getElementById(\"WeaponsDiv\").style = \"display:none;\";\r\n"
				+ "			document.getElementById(\"ArmorDiv\").style = \"\";\r\n"
				+ "		}\r\n"
				+ "	</script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Vanquish Legends</h1>\r\n"
				+ "	<div id=\"centerBox\" style=\"width:max; padding: 20px;\">\r\n"
				+ "		<h2>Shop</h2>\r\n"
				+ "		<p>Currently equipped gear will be sold for 80% value upon purchase</p>\r\n"
				+ "		<form action=\"game\" method=\"post\">\r\n"
				+ "			<div class=\"btn-group\" style=\"width: max-content; margin: auto;\">\r\n"
				+ "				<button type=\"button\" onclick=\"showWeapons()\">Weapons</button>\r\n"
				+ "				<button type=\"button\" onclick=\"showArmor()\">Armor</button>\r\n"
				+ "				<button type=\"submit\">Back</button>\r\n"
				+ "			</div>\r\n"
				+ "		</form>\r\n"
				+ "		<div id=\"WeaponsDiv\" style=\"\">\r\n"
				+ "			<table style=\"table-layout: fixed; width: 100%;\">\r\n"
				+ weaponsSection
				+ "			</table>\r\n"
				+ "		</div>\r\n"
				+ "		<div id=\"ArmorDiv\" style=\"display:none;\">\r\n"
				+ "			<table style=\"table-layout: fixed; width: 100%;\">\r\n"
				+ armorSection
				+ "			</table>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
		
}
