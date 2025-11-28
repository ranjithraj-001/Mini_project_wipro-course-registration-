import java.sql.*;
import java.util.*;


public class EnrollmentDAO {
public void enrollStudent(int studentId, int courseId) throws SQLException {
String sql = "INSERT INTO ENROLLMENT(STUDENT_ID, COURSE_ID) VALUES(?, ?)";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
ps.setInt(1, studentId);
ps.setInt(2, courseId);
ps.executeUpdate();
}
}


public List<Course> getEnrolledCourses(int studentId) throws SQLException {
List<Course> list = new ArrayList<>();
String sql = "SELECT c.course_id, c.title, c.credits FROM course c JOIN enrollment e ON c.course_id = e.course_id WHERE e.student_id = ?";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
ps.setInt(1, studentId);
try (ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
list.add(new Course(rs.getInt(1), rs.getString(2), rs.getInt(3)));
}
}
}
return list;
}
}