package linkedListDemo;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList();
		list.insertAtStart(2);
		list.insertAtStart(3);
		
		list.insertAtEnd(6);
		list.insertAtEnd(9);
		
		list.insertBetween(1, 6);
		list.insertBetween(5, 0);
		
		list.printList(list.head);
		
		list.removeAtStart();
		list.printList(list.head);
		
		list.removeAtEnd();
		list.printList(list.head);
		
		list.removeInBetween(4);
		list.printList(list.head);
		System.out.println("length: "+list.length());
		System.out.println("element: "+list.elementAt(2));
	}

}
