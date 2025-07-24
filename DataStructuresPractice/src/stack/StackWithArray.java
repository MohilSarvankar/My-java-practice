package stack;

public class StackWithArray {
	int a[];
	int top;
	int capacity;
	
	public StackWithArray(int capacity) {
		this.capacity = capacity;
		top = -1;
		a = new int[capacity];
	}
	
	public void push(int data) throws Exception {
		if(top == capacity-1)
			throw new Exception("Stack full");
		top++;
		a[top] = data;
	}
	
	public int pop() throws Exception {
		if(top == -1) {
			throw new Exception("Stack empty");
		}
		int res = a[top];
		top--;
		return res;
	}
	
	public int peek() throws Exception {
		if(top == -1) {
			throw new Exception("Stack empty");
		}
		return a[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top + 1;
	}

}
