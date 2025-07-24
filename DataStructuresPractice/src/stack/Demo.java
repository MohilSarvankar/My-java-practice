package stack;

public class Demo {
	
	public static void main(String[] args) {
		System.out.println("Stack with array");
		StackWithArray sa = new StackWithArray(3);
		try {
//			System.out.println(sa.peek());
			sa.push(1);
			sa.push(2);
			sa.push(3);
//			sa.push(4);
			System.out.println(sa.peek());
			System.out.println(sa.pop());
			System.out.println(sa.size());
			System.out.println(sa.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\nStack with linked list");
		StackWithList sl = new StackWithList();
		try {
//			System.out.println(sl.peek());
			sl.push(1);
			sl.push(2);
			sl.push(3);
			System.out.println(sl.peek());
			System.out.println(sl.pop());
			System.out.println(sl.size());
			System.out.println(sl.isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
