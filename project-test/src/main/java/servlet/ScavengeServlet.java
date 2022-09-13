package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scavenge")
public class ScavengeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		//Modify the character's gold and/or health based on game logic
		
		//Then return to the game page to see the updated data
		RequestDispatcher rd = request.getRequestDispatcher("game");
		rd.include(request, response);
		
	}
}
