package iteratorsDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleIterator {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Iterator<Integer> iterator1 = list1.iterator();
//		list1.add(7);  //throws exception
		
		System.out.println("All elements in list1: ");
		while(iterator1.hasNext()) {
			System.out.print(iterator1.next()+" ");
		}
		
		Iterator<Integer> iterator2 = list1.iterator();
		System.out.println("\n\nUsing remove method for removing odd numbers: ");
		while(iterator1.hasNext()) {
			int n = iterator2.next();
			if(n%2 != 0) {
				iterator2.remove();
			}
		}
		
		System.out.println("\nOriginal list: " + list1);
		
		List<Integer> list2 = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5,6));
		Iterator<Integer> iterator3 = list2.iterator();
		list2.add(7);
		
		System.out.println("\nAll elements in list2: ");
		while(iterator3.hasNext()) {
			System.out.print(iterator3.next()+" ");
		}
		
		Collection<Integer> list3 = new ConcurrentLinkedDeque<>(Arrays.asList(1,2,3,4,5,6));
		Iterator<Integer> iterator4 = list2.iterator();
		list3.add(7);
		
		System.out.println("\n\nAll elements in list3: ");
		while(iterator4.hasNext()) {
			System.out.print(iterator4.next()+" ");
		}
		
	}

}
