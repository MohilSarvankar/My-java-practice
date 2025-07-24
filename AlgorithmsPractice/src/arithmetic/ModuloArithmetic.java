package arithmetic;

public class ModuloArithmetic {
	
	//finding (a^b)%n using fast power and modulo
	//(a+b)%n = (a%n + b%n)%n
	//(a-b)%n = (a%n - b%n)%n
	//(a*b)%n = (a%n * b%n)%n
	
	public static void main(String[] args) {
		int a = 12;
		int b = 2;
		int n = 10;
		int res = 1;
		
		while(b>0) {
			if((b&1) != 0) {
				res = (res%n * a%n)%n;
			}
			b = b>>1;
			a = (a%n * a%n)%n;
		}
		
		System.out.println("Result (a^b)%n : " + res);
	}
}
