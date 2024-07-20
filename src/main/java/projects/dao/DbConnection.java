package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {

	private static String HOST = "localhost"; // my computer where MySQL is running from
	private static String PASSWORD = "projects_w7be";
	private static int PORT = 3306;
	private static String SCHEMA = "projects_w7be";
	private static String USER = "projects_w7be";

	// Connection
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("Connecting with uri=" + uri);

		// create a connection by asking driver manager which is a class in JDBC library
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Connection to schema '" + SCHEMA + "' is successful!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Unable to get connection at " + uri);
			throw new DbException("Unable to get connection at \" + uri");
		}
	}
}
