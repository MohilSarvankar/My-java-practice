package collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListPractice {

	public static void main(String[] args) {
		System.out.println("=====Arraylist without parameter=====");
		List list1 = new ArrayList<>();
		list1.add(1);
		list1.add("ABCD");
		list1.add(2.6757);
		list1.add(1,'H');
		list1.add(null);
		
		System.out.println(list1);
		System.out.println(list1.get(0));
		
		Object o1 = list1.get(2);
		System.out.println(o1);
		
		System.out.println("\n=====Arraylist=====");
		List<String> list2 = new ArrayList<>();
		list2.add("ABC");
		list2.add(null);
		list2.add("23");
		
		System.out.println(list2);
		System.out.println(list2.get(1));
		
		String s1 = list2.get(2);
		System.out.println(s1);
		
		System.out.println("\n=====Linkedlist=====");
		List<Integer> list3 = new LinkedList<>();
		list3.add(2);
		list3.add(45);
		list3.set(0, null);
		
		System.out.println(list3);
		System.out.println(list3.get(1));
		
		Integer i1 = list3.get(1);
		System.out.println(i1);
		
		System.out.println("\n=====Adding multiple elements by default =====");
		List<Integer> list4 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println(list4);
	}

}
