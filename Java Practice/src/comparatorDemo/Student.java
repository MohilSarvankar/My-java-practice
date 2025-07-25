package comparatorDemo;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	//for sorting with ids
	@Override
	public int compareTo(Student s) {
		return this.id - s.id;
	}
	
	//for sorting with names
//	@Override
//	public int compareTo(Student s) {
//		return this.name.compareTo(s.name);
//	}
	
	
}
