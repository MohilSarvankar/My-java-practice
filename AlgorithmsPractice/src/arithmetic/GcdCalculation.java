package arithmetic;

public class GcdCalculation {

	public static int euclidGcd(int a, int b) {
		if(a==0) return b;
		if(b==0) return a;
		
		if(a>b)
			return euclidGcd(b, a%b);
		else
			return euclidGcd(a, b%a);
	}
	
	public static void main(String[] args) {
		int a = 18;
		int b = 12;
		int gcd = euclidGcd(a, b);
		System.out.println("Gcd of "+a+" and "+ " is: "+ gcd);

	}

}
