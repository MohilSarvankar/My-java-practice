package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Previous smaller or greater element in an array
 * Refer: https://youtu.be/_RtghJnM1Qo?si=E3tT_0ykQEJC1Q4y
 */
public class PreviousSmallerGreaterElement {

	//Previous smaller: Brute force approach
	public static int[] previousSmallerElement1(int[] arr) {
		int n = arr.length;
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			boolean found = false;
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) {
					res[i] = arr[j];
					found = true;
					break;
				}
			}
			if(!found)
				res[i] = -1;
		}
		
		return res;
	}
	
	//Previous smaller: Optimum approach using stack
	public static int[] previousSmallerElement2(int[] arr) {
		Deque<Integer> s = new ArrayDeque<>();
		int n = arr.length;
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && s.peek() >= arr[i]) {
				s.pop();
			}
			if(s.isEmpty())
				res[i] = -1;
			else
				res[i] = s.peek();
			s.push(arr[i]);
		}
		
		return res;
	}
	
	//Previous greater: Optimum approach using stack
	public static int[] previousGreaterElement(int[] arr) {
		Deque<Integer> s = new ArrayDeque<>();
		int n = arr.length;
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && s.peek() <= arr[i])
				s.pop();
			
			if(s.isEmpty())
				res[i] = -1;
			else
				res[i] = s.peek();
			
			s.push(arr[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,10,5,8,20,15,3,12};
//		int[] res = previousSmallerElement1(arr);
//		int[] res = previousSmallerElement2(arr);
		int[] res = previousGreaterElement(arr);
		System.out.println("Previous smaller elements: "+ Arrays.toString(res));
	}

}
