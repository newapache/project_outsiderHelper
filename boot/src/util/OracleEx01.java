package util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleEx01 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@202.20.119.117:1521:orcl";
		String user = "dbp0207";
		String password = "dbp0207";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 성");
			DriverManager.getConnection(url, user, password);
			System.out.println("oracle 성");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver ����");
		} catch (SQLException e) {
			System.out.println("oracle �������");
		}
	}
	
} 