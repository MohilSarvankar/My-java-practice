package linkedListDemo;

/*
 * Floyd's Cycle Detection Algorithm
 * Refer: https://youtu.be/jcZtMh_jov0?si=hns2mOYrlStNJCc0
 */
public class CycleDetectionInList {
	
	public static Node detectCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return slow;  //or return true if cycle is present
		}
		
		return null; //or return false if cycle is absent
	}
	
	public static Node detectFirstNodeOfCycle(Node head) {
		if(head == null)
			return null;
		
		Node meet = detectCycle(head);
		Node start = head;
		while(meet != null && start != meet) {
			start = start.next;
			meet = meet.next;
		}
		
		return meet;
	}
	
	public static void removeCycle(Node head) {
		if(head == null)
			return;
		
		Node meet = detectCycle(head);
		Node start = head;
		Node prev = null;
		
		while(start != meet) {
			prev = meet;
			start = start.next;
			meet = meet.next;
		}
		if(meet != null)
			prev.next = null;
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insertAtEnd(2);
		list.insertAtEnd(5);
		list.insertAtEnd(1);
		list.insertAtEnd(5);
		list.insertAtEnd(2);
		list.printList(list.head);
		
		System.out.println("First node of cycle: "+ detectFirstNodeOfCycle(list.head));
	}

}
