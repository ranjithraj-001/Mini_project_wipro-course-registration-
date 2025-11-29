import java.sql.*;
public class first_example {
	static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(System.getenv("JDBC_NCSU_UN"));
			String user = "system"; 
			String passwd = "8725"; 
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DriverManager.getConnection(jdbcURL, user, passwd);
				stmt = conn.createStatement();

				stmt.executeUpdate("CREATE TABLE COFFEES1 " + "(COF_NAME VARCHAR(32), SUP_ID INTEGER, "
						+ "PRICE FLOAT, SALES INTEGER, TOTAL INTEGER)");

				stmt.executeUpdate("INSERT INTO COFFEES1 " + "VALUES ('Colombian', 101, 7.99, 0, 0)");

				stmt.executeUpdate("INSERT INTO COFFEES1 " + "VALUES ('French_Roast', 49, 8.99, 0, 0)");

				stmt.executeUpdate("INSERT INTO COFFEES1 " + "VALUES ('Espresso', 150, 9.99, 0, 0)");

				stmt.executeUpdate("INSERT INTO COFFEES1 " + "VALUES ('Colombian_Decaf', 101, 8.99, 0, 0)");

				stmt.executeUpdate("INSERT INTO COFFEES1 " + "VALUES ('French_Roast_Decaf', 49, 9.99, 0, 0)");

				rs = stmt.executeQuery("SELECT COF_NAME, PRICE FROM COFFEES1");

				while (rs.next()) {
					String s = rs.getString("COF_NAME");
					float n = rs.getFloat("PRICE");
					System.out.println(s + "   " + n);
				}

			} finally {
				close(rs);
				close(stmt);
				close(conn);
			}
		} catch (Throwable oops) {
			oops.printStackTrace();
		}
	}

	static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Throwable whatever) {
			}
		}
	}
}
