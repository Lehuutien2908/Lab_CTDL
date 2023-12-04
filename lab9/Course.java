package lab9;

import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return id + ", " + title + ", " + type + ", " + students + ", "
				+ lecturer;
	}
}
