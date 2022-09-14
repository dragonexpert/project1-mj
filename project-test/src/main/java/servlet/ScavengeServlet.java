package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ConnectionFactory;
import controller.QueryBuilder;
import repository.Characters;

@WebServlet("/scavenge")
public class ScavengeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory("java-angular-82322.cqrfh5fisbnz.us-west-1.rds.amazonaws.com", "postgres", 5432, "postgres", "password123");
        Connection connection = connectionFactory.createNewConnection();
        
        String username = request.getParameter("username");
        System.out.println(username);
        
		response.setContentType("text/html");
		//Modify the character's gold and/or health based on game logic
		int randomGold = (int) Math.ceil((Math.random() * 50) + 10);
		QueryBuilder queryBuilder1 = new QueryBuilder(connection, "repository.Characters");
        queryBuilder1.getColumns("*").fromTable("character_sheet").where("name", username, "=");
        		Characters characters =(Characters)queryBuilder1.getOne();
        int gold = characters.getGold() + randomGold;


        QueryBuilder queryBuilder6 = new QueryBuilder(connection, "repository.Characters");
        try {
			queryBuilder6.updateTable("character_sheet").setColumn("gold", gold).where("name", username, "=").executeOperation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//Then return to the game page to see the updated data
		RequestDispatcher rd = request.getRequestDispatcher("game");
		rd.include(request, response);
		
	}
}
