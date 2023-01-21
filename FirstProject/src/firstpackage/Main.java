package firstpackage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        ArrayList<School> schools = new ArrayList<School>();

        System.out.println("Please enter Department name: ");
        name = scanner.nextLine();

        while (true) {
            System.out.println("Please enter the school name: ");
            String schoolName = scanner.nextLine();
            ArrayList<Student> students = new ArrayList<Student>();

            while (true) {
                System.out.println("Please enter the student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Please enter the student ID: ");
                String studentId = scanner.nextLine();
                ArrayList<Course> courses = new ArrayList<Course>();
                while (true) {
                    System.out.println("Please enter the course name: ");
                    String courseName = scanner.nextLine();
                    System.out.println("Please enter the mark for " + courseName + ":");
                    int mark = scanner.nextInt();
                    scanner.nextLine();
                    courses.add(new Course(courseName, mark));

                    System.out.println("Do you want to add another course? (yes/no)");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("no")) {
                        break;
                    }
                }
                students.add(new Student(studentName, studentId, courses));
                System.out.println("Do you want to add another student? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }
            }
            schools.add(new School(schoolName, students));

            System.out.println("Do you want to add another school? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }
        scanner.close();

        System.out.println("Report for " + name);
        for (School school : schools) {
            System.out.println("School: " + school.name);
            for (Student student : school.students) {
                System.out.println("- Student Name: " + student.name + " (ID: " + student.id + ")");
                System.out.println("Courses: ");
                for (Course course : student.courses) {
                    System.out.println("- " + course.name + " (Mark: " + course.mark + ")");
                }
            }
        }
    }
}



