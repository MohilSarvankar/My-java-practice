package MyStack;

/*
 * Implementing stack using queue by making push method costly.
 */
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue1 {

	public static void main(String[] args) {
		Stack1 s1 = new Stack1();
		s1.push(1);
		s1.push(2);
		s1.display();
		s1.push(3);
		System.out.println(s1.size());
		s1.push(4);
		s1.display();
		
		System.out.println(s1.pop());
		s1.display();
		System.out.println(s1.pop());
		
		System.out.println(s1.top());
	}

}

class Stack1{
	public int n;
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	{
		n = 0;
	}
	
	public void push(int data) {
		q2.add(data);
		n++;
		
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public int pop() {
		if(q1.isEmpty())
			return -1;
		n--;
		return q1.poll();
	}
	
	public int top() {
		if(q1.isEmpty())
			return -1;
		return q1.peek();
	}
	
	public int size() {
		return n;
	}
	
	public void display() {
		System.out.println(q1);
	}
}
