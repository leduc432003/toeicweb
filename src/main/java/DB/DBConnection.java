package DB;
import java.sql.*;

public class DBConnection {
	public static Connection CreateConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/toeicmyclass";
		String username = "root";
		String password = "duc432003";
		
		try {
			// load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create connection
			conn = DriverManager.getConnection(url, username, password);
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
