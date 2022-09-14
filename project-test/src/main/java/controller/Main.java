package controller;

import java.sql.Connection;
import java.util.ArrayList;

public class Main
{
	Connection connection;
	
    public static void main(String[] args) throws Exception
    {
    	
    	ConnectionFactory connectionFactory = new ConnectionFactory("java-angular-82322.cqrfh5fisbnz.us-west-1.rds.amazonaws.com", "postgres", 5432, "postgres", "password123");
        Connection connection = connectionFactory.createNewConnection();

        // Generate a list example
        QueryBuilder queryBuilder = new QueryBuilder(connection, "repository.Character");
        queryBuilder = queryBuilder.getColumns("*").fromTable("character_sheet");
        queryBuilder.viewSQL();
        ArrayList<Object> userList;
        userList = queryBuilder.executeQuery();
        System.out.println("Rows: " + userList.size());
        System.out.println(userList.toString());
        System.out.println("\n\n\n");

}
}