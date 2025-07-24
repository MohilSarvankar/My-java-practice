package lambda;

public class Demo {
	
	public static void main(String[] args) {
//		Cat cat = new Cat();
		doPrinting((p, s) -> {
					System.out.println(p+ " Meow " + s);
					return "yo";
				});
	}

	public static void doPrinting(Printable obj) {
		obj.print("yo","!");
	}
}

@FunctionalInterface
interface Printable{
	String print(String p, String s);
}
