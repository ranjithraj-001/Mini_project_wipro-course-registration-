import java.sql.*;
import java.util.*;


public class CourseDAO {
public void addCourse(String title, int credits) throws SQLException {
String sql = "INSERT INTO COURSE(TITLE, CREDITS) VALUES(?, ?)";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
ps.setString(1, title);
ps.setInt(2, credits);
ps.executeUpdate();
}
}


public List<Course> getAllCourses() throws SQLException {
List<Course> list = new ArrayList<>();
String sql = "SELECT COURSE_ID, TITLE, CREDITS FROM COURSE";
try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
while (rs.next()) {
list.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
}
}
return list;
}
}