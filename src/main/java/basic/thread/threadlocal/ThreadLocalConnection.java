package basic.thread.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalConnection {
	
	private static ThreadLocal<Connection> t = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			try {
				return DriverManager.getConnection("", "", "");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		};
	};
	
	
	public Connection getConnection() {

		return t.get();
		
	}
	

}
