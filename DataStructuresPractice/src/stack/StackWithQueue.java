package stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithQueue {
	
	Queue<Integer> q1 = new ArrayDeque<>();
	Queue<Integer> q2 = new ArrayDeque<>();
	
	//O(1) - Non costly
	public void push1(int data) {
		q1.offer(data);
	}
	
	//O(n) - costly
	public int pop1() {
		while(q1.size() != 1)
			q2.offer(q1.poll());
		int res = q1.poll();
		//swapping queue references
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return res;
	}
	
	//O(n) - costly
	public void push2(int data) {
		while(!q1.isEmpty())
			q2.offer(q1.poll());
		q1.offer(data);
		while(!q2.isEmpty())
			q1.offer(q2.poll());
	}
	
	//O(1) - non costly
	public int pop2() {
		return q1.poll();
	}

	public static void main(String[] args) {
		StackWithQueue s1 = new StackWithQueue();
		s1.push1(2);
		s1.push1(3);
		s1.push1(4);
		System.out.println(s1.pop1());
		System.out.println(s1.pop1());
		
		StackWithQueue s2 = new StackWithQueue();
		s2.push2(2);
		s2.push2(3);
		s2.push2(4);
		System.out.println(s2.pop2());
		System.out.println(s2.pop2());
	}

}
