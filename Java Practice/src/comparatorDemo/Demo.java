package comparatorDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		System.out.println("====Demo with integer====");
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,5,2,8,3,-3,0));
		
		System.out.println(list1);
		list1.sort(Comparator.naturalOrder());
		System.out.println(list1);
		list1.sort(Comparator.reverseOrder());
		System.out.println(list1);
		
		System.out.println("\n====Demo with custom class====");
		List<Student> list2 = new ArrayList<>();
		list2.add(new Student(23, "akash"));
		list2.add(new Student(12, "ravi"));
		list2.add(new Student(46, "mohil"));
		list2.add(new Student(30, "harsh"));
		System.out.println(list2);
		
		System.out.println("\nBy implementing comparable interface====");
		list2.sort(Comparator.naturalOrder());
		System.out.println(list2);
		list2.sort(Comparator.reverseOrder());
		System.out.println(list2);
		
		System.out.println("\nBy creating new comparator====");
		list2.sort(new StudentComparator());
		System.out.println(list2);
	}

}

class StudentComparator implements Comparator<Student>{
	//for sorting with ids
//	@Override
//	public int compare(Student o1, Student o2) {
//		return o1.getId()-o2.getId();
//	}
	
	//for sorting with names
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
