package queue;

public class QueueWithArray {
	int[] a;
	int capacity;
	int rear;
	
	public QueueWithArray(int n) {
		capacity = n;
		a = new int[n];
		rear = -1;
	}
	
	public void enqueue(int data) {
		if(rear == capacity-1) {
			System.out.println("Queue full");
			return;
		}
		rear++;
		a[rear] = data;
	}
	
	public int dequeue() {
		if(rear == -1) {
			System.out.println("Queue empty");
			return -1;
		}
		int res = a[0];
		for(int i=0; i<rear; i++) {
			a[i] = a[i+1];
		}
		rear--;
		return res;
	}
	
	public void printQueue() {
		if(rear == -1) {
			System.out.println("Queue empty");
			return;
		}
		for(int i=0; i<=rear; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
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
