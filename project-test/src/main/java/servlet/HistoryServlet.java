package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		
		String[] enemiesBeaten = {"enemy1", "enemy2"};
		String[] enemiesLost = {"enemy3", "enemy4"};

		String beatString = "";
		for(String e : enemiesBeaten) {
			beatString += "<p>"+e+"</p>";
		}
		String lostString = "";
		for(String e : enemiesLost) {
			lostString += "<p>"+e+"</p>";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<link rel=\"stylesheet\" href=\"Style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Vanquish Legends</h1>\r\n"
				+ "	<div id=\"centerBox\" style=\"width:max; padding: 20px;\">\r\n"
				+ "		<h2>Battle History</h2>\r\n"
				+ "		<h3>Enemies you beat:</h3>"
				+ beatString
				+ "		<hr>"
				+ "		<h3>Enemies you lost to:</h3>"
				+ lostString
				+ "		\r\n"
				+ "		<form action=\"game\" method=\"post\">\r\n"
				+ "			<button type=\"submit\">Return</button>\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
