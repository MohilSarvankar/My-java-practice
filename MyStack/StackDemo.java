package MyStack;

public class StackDemo {

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		
		System.out.println("Poping element from top: "+stack.pop());
		System.out.println("Poping element from top: "+stack.pop());
		stack.display();
		
		System.out.println("Is stack empty: " + stack.isEmpty());
		System.out.println("Peeking element from stack top: " + stack.peek());
	}

}

class Stack{
	Node top;
	
	public void push(int data) {
		Node node = new Node();
		node.data = data;
		node.next = top;
		top = node;
	}
	
	public int pop() {
		Node temp = top;
		if(temp==null) {
			System.out.println("No elements in stack");
			return -1;
		}
		else {
			top = temp.next;
			temp.next = null;
			return temp.data;
		}
	}
	
	public int peek() {
		if(top==null) {
			System.out.println("No elements in stack");
			return -1;
		}
		else {
			return top.data;
		}
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public void display() {
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("Null");
	}
}

class Node{
	Node next;
	int data;
}
