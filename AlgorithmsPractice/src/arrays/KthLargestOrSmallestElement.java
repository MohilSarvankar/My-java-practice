package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Refer: https://youtu.be/yAs3tONaf3s?si=uLKs-LRTlNohoujA
 */
public class KthLargestOrSmallestElement {

	public static int findKthLargest(int a[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<k; i++) {
			pq.add(a[i]);
		}
		
		for(int i=k; i<a.length; i++) {
			if(a[i] > pq.peek()) {
				pq.poll();
				pq.add(a[i]);
			}
		}
		
		return pq.peek();
	}
	
	public static int findKthSmallest(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i=0; i<k; i++) {
			pq.add(a[i]);
		}
		
		for(int i=k; i<a.length; i++) {
			if(a[i] < pq.peek()) {
				pq.poll();
				pq.add(a[i]);
			}
		}
		
		return pq.peek();
	}
	
	public static void main(String[] args) {
		int[] a = {40,10,30,20,60,50};
		int k = 3;
		System.out.println("Kth largest element: " + findKthLargest(a, k));
		System.out.println("Kth smallest element: " + findKthSmallest(a, k));
	}

}
