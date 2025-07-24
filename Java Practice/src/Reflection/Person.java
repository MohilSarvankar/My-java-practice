package Reflection;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		this.name = "Default";
		this.age = 0;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void hello() {
		System.out.println("Hello, my name is " + this.name + " and I am " + this.age + " years old.");
	}
}
