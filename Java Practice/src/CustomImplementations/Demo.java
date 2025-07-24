package CustomImplementations;

public class Demo {
	
	public static void main(String[] args) {
		//MyInteger Demo
//		MyInteger i1 = new MyInteger(20);
//		MyInteger i2 = new MyInteger(10);
//		
//		System.out.println(i1 + " " + i2);
//		System.out.println("add : " + i1.add(i2));
//		System.out.println("subtract: " + i1.subtract(i2));
//		System.out.println("multiply: " + i1.multiply(i2));
//		System.out.println("divide: " + i1.divide(i2));
//		System.out.println("equals: " + i1.equals(i2));
//		System.out.println("valueOf: " + MyInteger.valueOf(45));
//		
//		//Caching example
//		MyInteger i3 = MyInteger.valueOf(30);
//		MyInteger i4 = MyInteger.valueOf(30);
//		System.out.println("i3 == i4 : " + (i3 == i4));
		
		
		//MyList Demo
		MyList<Integer> list = new MyList<>();
		System.out.println("isEmpty: " + list.isEmpty());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		System.out.println("size: " + list.size());
		System.out.println("isEmpty: " + list.isEmpty());
		System.out.println("list: " + list);
		
		list.remove(0);
		System.out.println("list: " + list);
		
		list.add(11);
		list.add(12);
		System.out.println("size: " + list.size());
	}
}
