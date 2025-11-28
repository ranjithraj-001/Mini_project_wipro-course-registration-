import java.sql.*;
import java.util.*;


public class StudentDAO {
public void addStudent(String name, String email) throws SQLException {
String sql = "INSERT INTO STUDENT(NAME, EMAIL) VALUES(?, ?)";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
ps.setString(1, name);
ps.setString(2, email);
ps.executeUpdate();
}
}


public List<Student> getAllStudents() throws SQLException {
List<Student> list = new ArrayList<>();
String sql = "SELECT STUDENT_ID, NAME, EMAIL FROM STUDENT";
try (Connection c = DBConnection.getConnection(); Statement st = c.createStatement(); ResultSet rs = st.executeQuery(sql)) {
while (rs.next()) {
list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));
}
}
return list;
}
}