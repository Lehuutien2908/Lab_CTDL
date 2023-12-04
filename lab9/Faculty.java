package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course res = null;
		int maxStudentCourse = 0;
		for (Course c : courses) {
			if (c.getType().equals("TH") && c.getStudents().size() > maxStudentCourse) {
				res = c;
				maxStudentCourse = c.getStudents().size();
			}
		}
		return res;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> res = new HashMap<>();
		for (Course c : courses) {
			for (Student st : c.getStudents()) {
				int key = st.getYear();
				List<Student> values = new ArrayList<>();
				if (!res.containsKey(key)) {
					values.add(st);
				} else {
					values = res.get(key);
					if (!values.contains(st)) {
						values.add(st);
					}
				}
				res.put(key, values);
			}

		}
		return res;
	}

	public Set<Course> filterCourses(String type) {
		List<Course> filteredList = new ArrayList<>();

		for (Course c : courses) {
			if (c.getType().equals(type)) {
				filteredList.add(c);
			}
		}

		Collections.sort(filteredList, new Comparator<Course>() {
			@Override
			public int compare(Course course1, Course course2) {
				int studentCount1 = course1.getStudents().size();
				int studentCount2 = course2.getStudents().size();

				return Integer.compare(studentCount2, studentCount1);
			}
		});

		return new HashSet<>(filteredList);
	}

	@Override
	public String toString() {
		return name + ", " + address + ", " + courses;
	}
}
