package queue;

import java.util.Stack;

public class QueueWithStack {
	
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	//O(1) - non costly
	public void enqueue1(int data) {
		s1.push(data);
	}
	
	//O(n) - costly
	public int dequeue1() {
		while(!s1.isEmpty())
			s2.push(s1.pop());
		int res = s2.pop();
		while(!s2.isEmpty())
			s1.push(s2.pop());
		return res;
	}
	
	//O(n) - costly
	public void enqueue2(int data) {
		while(!s1.isEmpty())
			s2.push(s1.pop());
		s1.push(data);
		while(!s2.isEmpty())
			s1.push(s2.pop());
	}
	
	//O(1) - non costly
	public int dequeue2() {
		return s1.pop();
	}
	
	public static void main(String[] args) {
		QueueWithStack q1 = new QueueWithStack();
		q1.enqueue1(2);
		q1.enqueue1(3);
		q1.enqueue1(4);
		System.out.println(q1.dequeue1());
		
		QueueWithStack q2 = new QueueWithStack();
		q2.enqueue2(2);
		q2.enqueue2(3);
		q2.enqueue2(4);
		System.out.println(q2.dequeue2());
	}

}
