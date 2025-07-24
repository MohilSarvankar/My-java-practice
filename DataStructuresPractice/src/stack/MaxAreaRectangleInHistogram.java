package stack;

import java.util.Stack;

/*
 * Refer: https://youtu.be/vhUxKxiconE?si=e1cI9McwU3sQk4P4
 */
public class MaxAreaRectangleInHistogram {
	
	//Brute force approach
	public static int maxAreaOfRectangle1(int[] a) {
		int n = a.length;
		int maxArea = 0;
		
		for(int i=0; i<n; i++) {
			int l = i;
			int r = i;
			
			while(l >= 0 && a[l] >= a[i])
				l--;
			
			while(r < n && a[r] >= a[i])
				r++;
			
			int area = (r - l - 1) * a[i];
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
	
	public static int[] previousSmaller(int[] a) {
		int n = a.length;
		int[] ps = new int[n];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<n; i++) {
			while(!s.isEmpty() && a[s.peek()]>=a[i])
				s.pop();
			
			if(s.isEmpty())
				ps[i] = -1;
			else
				ps[i] = s.peek();
			s.push(i);
		}
		
		return ps;
	}
	
	public static int[] nextSmaller(int[] a) {
		int n = a.length;
		int[] ns = new int[n];
		Stack<Integer> s = new Stack<>();
		
		for(int i=n-1; i>=0; i--) {
			while(!s.isEmpty() && a[s.peek()]>=a[i])
				s.pop();
			
			if(s.isEmpty())
				ns[i] = n;
			else
				ns[i] = s.peek();
			s.push(i);
		}
		
		return ns;
	}
	
	// Optimum approach using stack
	public static int maxAreaOfRectangle2(int[] a) {
		int maxArea = 0;
		int[] ps = previousSmaller(a);
		int[] ns = nextSmaller(a);
		
		for(int i=0; i<a.length; i++) {
			int area = (ns[i] - ps[i] - 1) * a[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}


	public static void main(String[] args) {
		int[] a = {4,2,1,5,6,3,2,4,2};
		System.out.println("Max area of rectangle: " + maxAreaOfRectangle1(a));
		System.out.println("Max area of rectangle: " + maxAreaOfRectangle2(a));
	}

}
