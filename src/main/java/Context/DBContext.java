package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			// DKI SQL Driver
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			
			// Thong so
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Wish;encrypt=true;trustServerCertificate=true";
			String userName = "sa";
			String password = "123";
			
			// connect
			c = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
}
