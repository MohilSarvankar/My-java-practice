package collectionFramework;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		System.out.println("=== Queue Demo ===");
		Queue<Integer> q1 = new LinkedList<>();
		q1.offer(2);
		q1.add(3);
		q1.offer(7);
		q1.offer(5);
		q1.offer(1);
		System.out.println("Original queue: " + q1);
		
		q1.remove();
		q1.poll();
		System.out.println("After removing element: "+q1);
		
		System.out.println("Element at head: "+q1.element());
		System.out.println("Element at head: "+q1.peek());
		
		System.out.println("\n=== Deque Demo ===");
		Deque<Integer> d1 = new ArrayDeque<>();
		d1.add(3);
		d1.addFirst(1);
		d1.addLast(5);
		d1.offer(6);
		d1.offerLast(8);
		d1.offerFirst(4);
		System.out.println("Original deque: "+d1);
		
		d1.poll();
		d1.removeFirst();
		System.out.println("After removing element: "+d1);
		
		System.out.println("First element: "+d1.getFirst());
		System.out.println("Last element: "+d1.peekLast());
		
		System.out.println("\n=== Priority Queue Demo ===");
		Queue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder());
		q2.add(7);
		q2.offer(3);
		q2.add(2);
		q2.offer(1);
//		q2.offer(5);
		System.out.println("Original priority queue: "+q2);
	}
}
