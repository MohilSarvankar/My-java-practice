package MyQueue;

import java.util.Stack;

/*
 * Implementing queue using stack by making enqueue costly
 */
public class QueueUsingStack1 {

	public static void main(String[] args) {
		Queue1 q = new Queue1();
		
		q.enqueue(1);
		q.display();
		q.enqueue(4);
		q.display();
		q.enqueue(2);
		q.display();
		q.enqueue(6);
		q.display();
		
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
		
		System.out.println("front: "+q.front());
		System.out.println("size: " + q.size());
		
	}

}

class Queue1{
	int n;
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	{
		n = 0;
	}
	
	public void enqueue(int data) {
		while(!s1.isEmpty()) {
			s2.add(s1.pop());
		}
		
		s1.add(data);
		n++;
		
		while(!s2.isEmpty()) {
			s1.add(s2.pop());
		}
	}
	
	public int dequeue() {
		if(s1.isEmpty())
			return -1;
		n--;
		return s1.pop();
	}
	
	public int front() {
		if(s1.isEmpty())
			return -1;
		return s1.peek();
	}
	
	public int size() {
		return n;
	}
	
	public void display() {
		System.out.println(s1);
	}
}
