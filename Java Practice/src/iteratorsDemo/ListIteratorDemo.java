package iteratorsDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		ListIterator<Integer> iterator1 = list1.listIterator();
		
		System.out.println("Iterating forward: ");
		while(iterator1.hasNext()) {
			System.out.print(iterator1.next() + " ");
		}
		
		System.out.println("\n\nIterating backward: ");
		while(iterator1.hasPrevious()) {
			System.out.print(iterator1.previous() + " ");
		}
		
		System.out.println("\n\nRemoved 2 while iterating forward: ");
		while(iterator1.hasNext()) {
			int n = iterator1.next();
			if(n==2) {
				iterator1.remove();
			}
		}

		System.out.println("\nOriginal list: "+ list1);
		
		System.out.println("\nSet 4 as 9 while iterating backward: ");
		while(iterator1.hasPrevious()) {
			int n = iterator1.previous();
			if(n==4) {
				iterator1.set(9);
			}
		}
		
		System.out.println("\nOriginal list: "+ list1);

		System.out.println("\n\nAdded 8 after 9 while iterating forward: ");
		while(iterator1.hasNext()) {
			int n = iterator1.next();
			if(n==9) {
				iterator1.add(8);
			}
		}
		
		System.out.println("\nOriginal list: "+ list1);
	}
}
