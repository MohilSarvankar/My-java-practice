package collectionFramework;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(5);
		set1.add(4);
		set1.add(3);
		set1.add(2);
		set1.add(3);
		set1.add(1);
		System.out.println("Original sewt: "+set1);
		
		Set<User> set2 = new HashSet<>();
		set2.add(new User(1,"mohil"));
		set2.add(new User(1,"mohil"));  //will be added if we don't override and add equals and hashcode methods in User class
		System.out.println("Object set: "+set2);
	}
}
