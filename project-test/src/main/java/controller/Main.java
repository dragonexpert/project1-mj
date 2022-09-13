package controller;

import java.sql.Connection;
import java.util.ArrayList;

public class Main
{
	Connection connection;
	
    public static void main(String[] args) throws Exception
    {
    	
    	ConnectionFactory connectionFactory = new ConnectionFactory("----", "----", ----, "---", "---");
        Connection connection = connectionFactory.createNewConnection();

        // Generate a list example
        QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.Weapons");
        queryBuilder = queryBuilder.getColumns("*").fromTable("weapons");
        queryBuilder.viewSQL();
        ArrayList<Object> userList;
        userList = queryBuilder.executeQuery();
        System.out.println("Rows: " + userList.size());
        System.out.println(userList.toString());
        System.out.println("\n\n\n");

}
}