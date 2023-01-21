package firstpackage;

import java.util.ArrayList;

public class Student {
	String name;
	String id;
	ArrayList<Course> courses;

	public Student(String name, String id, ArrayList<Course> courses) {
		this.name = name;
		this.id = id;
		this.courses = courses;
	}
}