package MyQueue;
/*
 * Implementing queue using stack by making dequeue costly
 */
import java.util.Stack;

public class QueueUsingStack2 {

	public static void main(String[] args) {
		Queue2 q = new Queue2();
		
		q.enqueue(1);
		q.display();
		q.enqueue(4);
		q.display();
		q.enqueue(2);
		q.display();
		q.enqueue(6);
		q.display();
		
		System.out.println(q.dequeue());
		q.display();
		q.enqueue(10);
		q.display();
		System.out.println(q.dequeue());
		q.display();
		
		System.out.println("front: "+q.front());
		System.out.println("size: " + q.size());
	}

}

class Queue2{
	int n;
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	{
		n = 0;
	}
	
	public void enqueue(int data) {
		s1.push(data);
		n++;
	}
	
	public int dequeue() {
		if(s1.isEmpty() && s2.isEmpty())
			return -1;
		
		if(!s2.isEmpty()) {
			n--;
			return s2.pop();
		}
		else {
			while(!s1.isEmpty()) {
				s2.add(s1.pop());
			}
			n--;
			return s2.pop();
		}
	}
	
	public int front() {
		if(s1.isEmpty() && s2.isEmpty())
			return -1;
		
		if(!s2.isEmpty()) {
			return s2.peek();
		}
		else {
			while(!s1.isEmpty()) {
				s2.add(s1.pop());
			}
			return s2.peek();
		}
	}
	
	public int size() {
		return n;
	}
	
	public void display() {
		System.out.print(s1);
		System.out.println(s2);
	}
}
