package firstpackage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
    	int choice;
        Scanner input = new Scanner(System.in);
        
        ArrayList<School> schools = new ArrayList<School>();
        String name = null;
        do {
        	
          System.out.println(" WELCOME ");
          System.out.println(" *************** ");
          System.out.println("Please select an option");
          System.out.println("1. User Input");
          System.out.println("2. Report");
          System.out.println("3. Exit");
          System.out.print("Enter your choice: ");
          choice = input.nextInt();
          input.nextLine();
          switch (choice) {
            case 1:
            	
              System.out.println("Please enter Department name: ");
              name = input.nextLine();
              while (true) {
                System.out.println("Please enter the school name: ");
                String schoolName = input.nextLine();
                ArrayList<Student> students = new ArrayList<Student>();

                while (true) {
                  System.out.println("Please enter the student name: ");
                  String studentName = input.nextLine();
                  System.out.println("Please enter the student ID: ");
                  String studentId = input.nextLine();
                  ArrayList<Course> courses = new ArrayList<Course>();
                  while (true) {
                    System.out.println("Please enter the course name: ");
                    String courseName = input.nextLine();
                    int mark;
                    do {
                      System.out.println("Please enter the mark for " + courseName + ":");
                      mark = input.nextInt();
                      input.nextLine();
                      if (mark < 0 || mark > 100) {
                        System.out.println("Invalid mark. Please enter a mark between 0 and 100.");
                      }
                    } while (mark < 0 || mark > 100);
                    courses.add(new Course(courseName, mark));
                    System.out.println("Do you want to add another course? (yes/no)");
                    String response = input.nextLine();
                    if (response.equalsIgnoreCase("no")) {
                      break;
                    }
                  }

                  students.add(new Student(studentName, studentId, courses));
                  System.out.println("Do you want to add another student? (yes/no)");
                 String response = input.nextLine();
                  if (response.equalsIgnoreCase("no")) {
                    break;
                  }
                }
                schools.add(new School(schoolName, students));

                System.out.println("Do you want to add another school? (yes/no)");
                String response = input.nextLine();
                if (response.equalsIgnoreCase("no")) {
                  break;
                }
              }
              break;
            case 2:
              if (schools.isEmpty()) {
                System.out.println("No data found. Please input data first.");
              } else {
                System.out.println("Report for " + name);
                for (School school : schools) {
                	System.out.println("\"School: \" "+ school.name);
                	for (Student student : school.students) {
                		System.out.println("- Student Name: " + student.name + " (ID: " + student.id + ")");
                		System.out.println("Courses: ");
                		for (Course course : student.courses) {
                		System.out.println("- " + course.name + " (Mark: " + course.mark + ")");
                		}
                		}
                		}
                		}
                		break;
                		case 3:
                		System.out.println("Exiting program.");
                		break;
                		default:
                		System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                		}
                		} while (choice != 3);
                		input.close();
    }
}



