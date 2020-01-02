package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionManager {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@202.20.119.117:1521:orcl";
	String user = "dbp0207";
	String password = "dbp0207";
	Connection conn = null;
    
    public ConnectionManager() {
    	try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
		} catch (Exception ex) {
			ex.printStackTrace();
		}    	   
    }

    public Connection getConnection() {

    	try {
    		conn = DriverManager.getConnection(url, user, password);
    		System.out.println("오라클 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
    }
    
    public void close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


}
