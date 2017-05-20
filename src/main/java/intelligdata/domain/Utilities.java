package intelligdata.domain;

import java.util.Arrays;
import java.util.List;

public class Utilities {
	static public List<Course> getCourses1(){
		Course c1=new Course("DSP", 3);
		Course c2=new Course("DSP", 3);
		Course c3=new Course("ALgorithm", 2);
		return Arrays.asList(c1,c2,c3);
	}
	static public List<Course> getCourses2(){
		Course c1=new Course("FPP", 3);
		Course c2=new Course("MPP", 3);
		Course c3=new Course("EA", 2);
		return Arrays.asList(c1,c2,c3);
	}
	static public School getSchool(){
		School school=new School("MIT");
		Student s1= new Student("John SMith", school);
		s1.addCourse(1, getCourses1());
		s1.addCourse(2, getCourses2());
		
		Student s2= new Student("Jack Bauer", school);
		s2.addCourse(2, getCourses1());
		s2.addCourse(1, getCourses2());
		school.addStudent(s1);school.addStudent(s2);
		return school;
	}
}
