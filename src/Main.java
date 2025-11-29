import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentDAO sdao = new StudentDAO();
    static CourseDAO cdao = new CourseDAO();
    static EnrollmentDAO edao = new EnrollmentDAO();

    public static void main(String[] args) {
        System.out.println("=== Course Registration System ===");
        while (true) {
            System.out.println("\n1. Admin (manage courses)\n2. Student (register/enroll/view)\n3. Exit");
            System.out.print("Choose: ");
            String ch = sc.nextLine().trim();
            try {
                switch (ch) {
                    case "1": adminMenu(); break;
                    case "2": studentMenu(); break;
                    case "3": System.out.println("Bye"); System.exit(0);
                    default: System.out.println("Invalid");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    static void adminMenu() throws Exception {
        while (true) {
            System.out.println("\n--- Admin ---\n1.Add course\n2.View courses\n3.Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();
            if (c.equals("1")) {
                System.out.print("Course title: ");
                String t = sc.nextLine();
                System.out.print("Credits: ");
                int cr = Integer.parseInt(sc.nextLine());
                cdao.addCourse(t, cr);
                System.out.println("Course added.");
            } else if (c.equals("2")) {
                List<Course> courses = cdao.getAllCourses();
                System.out.println("Courses:");
                for (Course co: courses) System.out.println(co.courseId + ") " + co.title + " (" + co.credits + ")");
            } else if (c.equals("3")) return;
            else System.out.println("Invalid");
        }
    }

    static void studentMenu() throws Exception {
        while (true) {
            System.out.println("\n--- Student ---\n1.Register student\n2.View courses\n3.Enroll in course\n4.My enrollments\n5.Back");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();
            if (c.equals("1")) {
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                sdao.addStudent(name, email);
                System.out.println("Student registered.");
            } else if (c.equals("2")) {
                List<Course> courses = cdao.getAllCourses();
                for (Course co: courses) System.out.println(co.courseId + ") " + co.title + " (" + co.credits + ")");
            } else if (c.equals("3")) {
                System.out.print("Your student id: "); int sid = Integer.parseInt(sc.nextLine());
                System.out.print("Course id to enroll: "); int cid = Integer.parseInt(sc.nextLine());
                edao.enrollStudent(sid, cid);
                System.out.println("Enrolled.");
            } else if (c.equals("4")) {
                System.out.print("Your student id: "); int sid = Integer.parseInt(sc.nextLine());
                List<Course> list = edao.getEnrolledCourses(sid);
                System.out.println("Your enrollments:");
                for (Course co: list) System.out.println(co.courseId + ") " + co.title);
            } else if (c.equals("5")) return;
            else System.out.println("Invalid");
        }
    }
}
