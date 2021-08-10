package MyLinkedList;

public class Demo {
	public static void main(String[] args) {
		MyList list1 = new MyList();
		list1.insertAtEnd(5);
		list1.insertAtEnd(4);
		list1.insertAtEnd(3);
		list1.insertAtStart(1);
		list1.insertAt(10, 1);
		list1.remomveAt(2);
		
		Node head = list1.getHead();
		
		System.out.print("Original linked list: ");
		list1.display(head);
		
//		Node newHead = list1.reverseList(head);
//		System.out.print("Reversed linked list: ");
//		list1.display(newHead);
		
//		Node newHead = list1.reverseWithRecursion(head);
//		System.out.print("Reversed linked list: ");
//		list1.display(newHead);
		
//		System.out.println(list1.size());
//		
//		list1.removeFirst();
//		list1.display();
//		
//		list1.remomveLast();
//		list1.display();
//		
//		list1.remomveLast();
//		list1.display();
//		
//		list1.remomveLast();
//		list1.display();
	}
}
