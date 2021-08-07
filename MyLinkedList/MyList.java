package MyLinkedList;

public class MyList {
	Node head;
	
	public Node getHead() {
		return head;
	}
	
	public void insertAtEnd(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head==null) {
			head = node;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
	}
	
	public void removeFirst() {
		Node temp = head;
		head = temp.next;
		temp.next = null;
	}
	
	public void remomveLast() {
		Node temp = head;
		if(temp.next == null) {
			head = null;
		}
		else {
			while(temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	public int size() {
		Node temp = head;
		int len=0;
		while(temp!=null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	public void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("Null");
		System.out.println();
	}
	
	//reversing linked list by 3 pointer method
	public Node reverseList(Node head) {
		Node previous = null;
		Node current = head;
		Node next;
		
		while(current != null) {
			next = current.next;
			
			current.next = previous;  //pointing current node to previous node
			previous = current;
			current = next;
		}
		
		return previous;  //this will be new head for reversed liked list
	}
	
	//reversing linked list with recursive method
	public Node reverseWithRecursion(Node head) {
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node newHead = reverseWithRecursion(head.next);
		
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
}
