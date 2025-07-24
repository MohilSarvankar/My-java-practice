package linkedListDemo;

public class MyLinkedList {
	Node head;
	
	public void insertAtStart(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = head;
		head = temp;
	}
	
	public void insertAtEnd(int data) {
		Node temp = new Node();
		Node current = head;
		temp.data = data;
		temp.next = null;
		if(current == null) {
			head = temp;
		}
		else {
			while(current.next!=null) current = current.next;
			current.next = temp;
		}
	}
	
	public void insertBetween(int data, int index) {
		Node temp = new Node();
		Node current = head;
		temp.data = data;
		if(current == null || index == 0) {
			temp.next = head;
			head = temp;
		}
		else {
			int i = 0;
			while(i<index-1) {
				if(current.next == null) {
					System.out.println("Index " + index + " is greater than length of list");
					return;
				}
				current = current.next;
				i++;
			}
			temp.next = current.next;
			current.next = temp;
		}
		
	}
	
	public void removeAtStart() {
		Node temp = head;
		if(temp != null) {
			head = temp.next;
			temp.next = null;
		}
	}
	
	public void removeAtEnd() {
		Node temp = head;
		if(temp!=null) {
			if(temp.next==null) {
				head = null;
			}
			else {
				while(temp.next.next != null) {
					temp = temp.next;
				}
				temp.next = null;
			}
		}
	}
	
	public void removeInBetween(int index) {
		Node previous = null;
		Node current = head;
		if(current != null) {
			if(index == 0) {
				head = current.next;
				current.next = null;
			}
			else {
				int i = 0;
				while(i<index) {
					if(current.next == null) {
						System.out.println("Index " + index + " is greater than length of list");
						return;
					}
					previous = current;
					current = current.next;
					i++;
				}
				previous.next = current.next;
				current.next = null;
			}
		}
	}
	
	public int elementAt(int index) {
		Node temp = head;
		if(temp!=null) {
			int i = 0;
			while(i<index) {
				if(temp.next == null) {
					System.out.println("Index " + index + " is greater than length of list");
					return -1;
				}
				temp = temp.next;
				i++;
			}
			return temp.data;
		}
		return -1;
	}
	
	public int length() {
		Node temp = head;
		int count = 0;
		while(temp!=null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	public void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
}
