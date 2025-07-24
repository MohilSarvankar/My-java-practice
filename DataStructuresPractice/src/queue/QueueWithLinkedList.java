package queue;

import linkedListDemo.MyLinkedList;
import linkedListDemo.Node;

public class QueueWithLinkedList {
	
	Node front, rear;
	
	public void enqueue(int data) {
		Node temp = new Node(data);
		if(front == null) {
			front = rear = temp;
		}
		else {
			rear.next = temp;
			rear = temp;
		}
	}
	
	public int dequeue() {
		if(front == null) {
			return -1;
		}
		Node temp = front;
		front = front.next;
		temp.next = null;
		return temp.data;
	}
	
	public void printQueue() {
		Node temp = front;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("Null\n");
	}

	public static void main(String[] args) {
		QueueWithLinkedList q = new QueueWithLinkedList();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.printQueue();
		System.out.println(q.dequeue());
		q.printQueue();
		q.enqueue(5);
		q.printQueue();
	}

}
