package intelligdata.domain;


public class Person{
	String fname;
	String lname;
	int age;
	public Person(){// This constructor is mandatory for Kryo to work
		
	}
	public Person(String fname, String lname, int age) {
		this.fname=fname;
		this.lname=lname;
		this.age=age;
	}
	@Override
	public String toString(){
		return fname+" "+lname+" "+age;
	}
	public void print(){
		System.out.println(this);
	}
}