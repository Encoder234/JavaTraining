package module5.activity2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/training_db";

		String username = "postgres";
		String password = "postgres";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connected successfully");
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
//			
//			while (rs.next()) {
//				System.out.println(rs.getString("name"));
//			}

			//int rows = stmt.executeUpdate("INSERT INTO students VALUES (1, 'John')");

//			rs.close();
//			stmt.close();
			conn.close();

			
		} catch (SQLException e) {
			System.out.println("Error Connection Failed: " + e.getMessage());
			e.printStackTrace();
		} //try
	}
}
