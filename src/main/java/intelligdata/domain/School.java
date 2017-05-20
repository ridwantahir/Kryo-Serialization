package intelligdata.domain;

import java.util.ArrayList;
import java.util.List;

public class School {
	String name;
	List<Student> students;
	public School(){
		students=new ArrayList<Student>();
	}
	School(String name){
		this();
		this.name=name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Student> getStudents() {
		return students;
	}
	public String getName(){
		return this.name;
	}
	public void addStudent(Student student){
		student.setSchool(this);
		students.add(student);
	}
	@Override
	public String toString(){
		String res=name+" teaching... \n";
		for(Student student: students){
			res+=student.toString();
		}
		return res;
	}
	public void print(){
		System.out.print(this);
	}
}
