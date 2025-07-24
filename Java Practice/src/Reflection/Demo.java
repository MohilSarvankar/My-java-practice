package Reflection;

import java.lang.reflect.*;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		Person p1 = new Person("Avin", 20);
		p1.hello();
		
		Class<?> personClass = Class.forName("Reflection.Person");
		Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
		Person p2 = (Person)constructor.newInstance("Mohil", 10);
		
		Field nameField = personClass.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(p2, "yo");
		
		Method helloMethod = personClass.getDeclaredMethod("hello");
		helloMethod.invoke(p2);
	}
	
}
