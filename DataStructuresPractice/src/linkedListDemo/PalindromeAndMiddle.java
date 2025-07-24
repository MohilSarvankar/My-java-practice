package linkedListDemo;

public class PalindromeAndMiddle {
	
	public static Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static boolean isPalindrome(Node head) {
		if(head == null)
			return true;
		
		Node middle = findMiddle(head);
		Node last = ReverseLinkedList.reverseList1(middle);
		Node curr = head;
		
		while(last != null) {
			if(curr.data != last.data)
				return false;
			curr = curr.next;
			last = last.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insertAtEnd(2);
//		list.insertAtEnd(5);
//		list.insertAtEnd(1);
//		list.insertAtEnd(5);
		list.insertAtEnd(2);
		list.printList(list.head);
		
		System.out.println("Palindrome: "+isPalindrome(list.head));
	}

}
