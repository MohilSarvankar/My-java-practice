package MyStack;
/*
 * Implementing stack using queue by making pop method costly.
 */
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue2 {

	public static void main(String[] args) {
		Stack2 s1 = new Stack2();
		s1.push(1);
		s1.push(2);
		s1.display();
		s1.push(3);
		s1.display();
		
		System.out.println(s1.size());
		s1.push(4);
		s1.display();
		
		System.out.println(s1.pop());
		s1.display();
		System.out.println(s1.pop());
		
		System.out.println(s1.top());
		s1.display();
	}

}

class Stack2{
	public int n;
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	{
		n = 0;
	}
	
	public void push(int data) {
		q1.add(data);
		n++;
	}
	
	public int pop() {
		if(q1.isEmpty())
			return -1;
		
		while(q1.size() != 1) {
			q2.add(q1.poll());
		}
		
		int ans = q1.poll();
		n--;
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return ans;
	}
	
	public int top() {
		if(q1.isEmpty())
			return -1;
		
		while(q1.size() != 1) {
			q2.add(q1.poll());
		}
		
		int ans = q1.poll();
		q2.add(ans);
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return ans;
	}
	
	public int size() {
		return n;
	}
	
	public void display() {
		System.out.println(q1);
	}
}