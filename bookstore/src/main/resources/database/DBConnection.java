package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection instance = null;
	private Connection connection = null;
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "#Root123");
		} catch (ClassNotFoundException e) {
			System.err.println("Database driver not found : " + e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnection();
        }
        return instance;
    }
}