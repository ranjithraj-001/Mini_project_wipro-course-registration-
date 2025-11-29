
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
	static final String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	private static String user_name = Creds.userName;
	private static String password = Creds.password;

	private JDBC_Connection() {

	}

	public static Connection makeConnection() {
		Connection conn = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			try {

				conn = DriverManager.getConnection(jdbcURL, user_name, password);

			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} catch (Throwable oops) {
			oops.printStackTrace();
		}

		return conn;
	}

	static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable whatever) {
			}
		}
	}

}
