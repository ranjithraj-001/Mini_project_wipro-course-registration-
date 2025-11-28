import java.sql.*;


public class DBConnection {
// update these values to match your local Oracle DB
public static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
public static final String DB_USER = "system"; // change if you created a different user
public static final String DB_PASS = "8725"; // change to your password


static {
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
System.err.println("Oracle JDBC Driver not found. Make sure ojdbc8.jar is on the classpath.");
e.printStackTrace();
}
}


public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
}
}