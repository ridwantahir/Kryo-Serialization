package intelligdata.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	String fullname;
	School school;
	Map<Integer, Course> courses;
	Student(){// This constructor is required
		courses=new HashMap<Integer, Course>();
	}
	Student(String fullname, School school){
		this();
		this.fullname=fullname;
		this.school=school;
	}
	public void setSchool(School school){
		this.school=school;
	}
	@Override
	public String toString(){
		String res=fullname+" @ "+ school.getName()+" taking: \n";
		for(Integer year: courses.keySet()){
			res+=courses.get(year).toString()+"in: "+year+", ";
		}
		
		return res+"\n";
	}
	public void addCourse(Integer year,List<Course> newcourses){
		for(Course course: newcourses){
			courses.put(year, course);
		}
	}
}
