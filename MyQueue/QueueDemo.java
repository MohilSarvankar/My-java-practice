package MyQueue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.display();
		
		System.out.println("Front emement: " + queue.queueFront());
		System.out.println("Rear emement: " + queue.queueRear());
		
		queue.dequeue();
		queue.dequeue();
		queue.display();
		
		System.out.println("Is empty: " + queue.isEmpty());
	}
}

class Queue{
	Node front, rear;
	
	public void enqueue(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(rear==null) {
			front = node;
			rear = node;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}
	
	public int dequeue() {
		if(front == null) {
			System.out.println("Queue is already empty");
			return -1;
		}
		else {
			Node temp = front;
			front = temp.next;
			temp.next = null;
			return temp.data;
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public void display() {
		Node temp = front;
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		
		System.out.println("Null");
	}
	
	public int queueFront() {
		if(front != null)
			return front.data;
		System.out.println("No elements in queue");
		return -1;
	}
	
	public int queueRear() {
		if(rear != null)
			return rear.data;
		System.out.println("No elements in queue");
		return -1;
	}
}

class Node{
	int data;
	Node next;
}
