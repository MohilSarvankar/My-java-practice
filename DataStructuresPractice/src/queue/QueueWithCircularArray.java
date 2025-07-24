package queue;

public class QueueWithCircularArray {
	int[] a;
	int n;
	int front = -1, rear = -1;
	
	public QueueWithCircularArray(int n) {
		this.n = n;
		a = new int[n];
	}
	
	public void enqueue(int data) {
		if((rear+1)%n == front) {
			System.out.println("Queue full");
			return;
		}
		if(front == -1) front = 0;
		rear = (rear + 1)%n;
		a[rear] = data;
	}
	
	public int dequeue() {
		if(front == -1) {
			System.out.println("Queue empty");
			return -1;
		}
		int res = a[front];
		if(rear == front)
			rear = front = -1;
		else
			front = (front + 1)%n;
		return res;
	}
	
	public void printQueue() {
		if(front == -1) {
			System.out.println("Queue empty");
			return;
		}
		int i = front;
		while(i != rear) {
			System.out.print(a[i] + " ");
			i = (i+1)%n;
		}
		System.out.print(a[i] + "\n");
	}

	public static void main(String[] args) {
		QueueWithArray q = new QueueWithArray(5);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.printQueue();
		q.enqueue(5);
		q.enqueue(6);
//		q.enqueue(7);
		q.printQueue();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.printQueue();
		
	}

}
