package linkedListDemo;

public class ReverseLinkedList {
	
	//3 pointer approach
	public static Node reverseList1(Node head) {
		Node newHead = null;
		Node prev = null;
		Node curr = head;
		
		while(curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		newHead = prev;
		return newHead;
	}
	
	//Recursive approach
	public static Node reverseList2(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node newHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insertAtEnd(5);
		list.insertAtEnd(2);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.printList(list.head);
		
		Node newHead = reverseList1(list.head);
		list.printList(newHead);
		
		newHead = reverseList2(newHead);
		list.printList(newHead);
	}
}
