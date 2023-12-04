package lab9;

import java.util.Arrays;
import java.util.List;

public class TestFaculty {
	public static void main(String[] args) {
		
		Student st1 = new Student("111", "Le Huu Tien", 2003);
		Student st2 = new Student("112", "Nguyen Anh Tuan", 2004);
		Student st3 = new Student("113", "Pham Van Linh", 2004);
		
		List<Student> studentCourse1 = Arrays.asList(st1, st3);
		List<Student> studentCourse2 = Arrays.asList(st2, st3);
		List<Student> studentCourse3 = Arrays.asList(st1, st2, st3);
		
		Course c1 = new Course("321", "CNXH", "LT", studentCourse2, "Nguyen Thanh Long");
		Course c2 = new Course("322", "CTDL", "TH", studentCourse1, "Nguyen Van Du");
		Course c3 = new Course("323", "GDTC", "TH", studentCourse3, "Nguyen Khang");
		
		List<Course> courses = Arrays.asList(c1, c2, c3);
		
		Faculty f = new Faculty("CNTT", "DH Nong Lam TP.HCM", courses);
		
		//method maxPracticalCourse
		System.out.println(f.getMaxPracticalCourse());
		//method groupByYear
		System.out.println(f.groupStudentsByYear());
		//method filterCourse
		System.out.println(f.filterCourses("TH"));
	}
}
