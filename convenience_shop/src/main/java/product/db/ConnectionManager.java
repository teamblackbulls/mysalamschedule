package product.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER="Shop";
	private static final String DB_PASSWORD="system";
	
	public static Connection getConnection() {
		try {
			//load the driver
			Class.forName(DB_DRIVER);
			
			try {
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return con;
	}
}
