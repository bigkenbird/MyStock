package bigkenbird.MyStock.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlConnect {

	private static final String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String connurl="jdbc:sqlserver://localhost:1433;databaseName=MyStock";
	private static final String sqlaccount="sa";
	private static final String sqlpassword="password";
	
	public static Connection conn=null;
	
	
	static {
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(connurl,sqlaccount,sqlpassword);
			if(conn==null) {
				System.out.println("資料庫連線失敗");
			}
			else {
				System.out.println("資料庫連線成功");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("資料庫連線失敗");
			e.printStackTrace();
		}
	}
	
	
}
