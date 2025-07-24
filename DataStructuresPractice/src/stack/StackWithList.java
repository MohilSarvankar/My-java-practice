package stack;

import linkedListDemo.Node;

public class StackWithList {
	Node head;
	int size;
	
	public StackWithList() {
		head = null;
		size = 0;
	}
	
	public void push(int data){
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size++;
	}
	
	public int pop() throws Exception {
		if(head == null)
			throw new Exception("Stack empty");
		int res = head.data;
		Node temp = head;
		head = head.next;
		temp.next = null;
		size--;
		return res;
	}
	
	public int peek() throws Exception {
		if(head == null)
			throw new Exception("Stack empty");
		return head.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return size;
	}
}
