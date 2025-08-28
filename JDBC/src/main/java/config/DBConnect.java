package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private final String serverName = "localhost";
	private final String dbName = "LapTrinhWEB";
	private final String portNumber = "1433";
	private final String instance = ""; // Nếu không có instance, để trống
	private final String userID = "sa";
	private final String password = "12345";
	private Connection conn;

	public Connection getConnection() {
		String url = "jdbc:sqlserver://" + serverName;
		if (!instance.trim().isEmpty()) {
			url += "\\" + instance;
		}
		url += ":" + portNumber + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url, userID, password);
			System.out.println("Kết nối thành công!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Kết nối thất bại!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		DBConnect connect = new DBConnect();
		Connection conn = connect.getConnection();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}