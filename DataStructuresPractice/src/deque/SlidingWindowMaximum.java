package deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/*
 * Find maximum in every window of size k
 * Refer: https://youtu.be/MCvGwtkqJS0?si=V8l3n0PneF_GV8zl
 */
public class SlidingWindowMaximum {
	
	public static int[] findMaximumInWindow1(int[] a, int k) {
		int n = a.length;
		int[] res = new int[n-k+1];
		int max = 0;
		
		for(int i=0; i<n-k+1; i++) {
			max = a[i];
			for(int j=i+1; j<i+k; j++) {
				if(a[j] > max)
					max = a[j];
			}
			res[i] = max;
		}
		
		return res;
	}
	
	public static int[] findMaximumInWindow2(int[] a, int k) {
		int n = a.length;
		int[] res = new int[n-k+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i=0; i<k; i++) {
			pq.add(a[i]);
		}
		
		res[0] = pq.peek();
		pq.remove(a[0]);
		
		for(int i=k; i<n; i++) {
			pq.add(a[i]);
			res[i-k+1] = pq.peek();
			pq.remove(a[i-k+1]);
		}
		
		return res;
	}
	
	public static int[] findMaximumInWindow3(int[] a, int k) {
		int n = a.length;
		int[] res = new int[n-k+1];
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i=0; i<k; i++) {
			while(!dq.isEmpty() && a[dq.peekLast()]<a[i])
				dq.pollLast();
			dq.offerLast(i);
		}
		
		for(int i=k; i<n; i++) {
			res[i-k] = dq.peekFirst();
			
			while(!dq.isEmpty() && dq.peekFirst()<=i-k)
				dq.pollFirst();
			
			while(!dq.isEmpty() && a[dq.peekLast()]<a[i])
				dq.pollLast();
			
			dq.offerLast(i);
		}
		
		res[n-k] = dq.peekFirst();
		
		return res;
	}

	public static void main(String[] args) {
		int[] a = {4,1,3,5,1,2,3};
		int k = 3;
		
//		int[] res = findMaximumInWindow1(a, k);
//		int[] res = findMaximumInWindow2(a, k);
		int[] res = findMaximumInWindow2(a, k);
		
		System.out.println(Arrays.toString(res));
	}

}
