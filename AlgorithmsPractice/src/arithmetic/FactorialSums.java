package arithmetic;

public class FactorialSums {
	public static long factorial(int n) {
		long res = 1;
		while(n!=1) {
			res = res*n;
			n--;
		}
		return res;
	}
	
	//Finding trailing zeros in factorial
	public static int factorialTrailingZeros(int n) {
		int res = 0;
		for(int i=5; i<=n; i=i*5) {
			res += n/i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Factorial of 5: "+factorial(5));
		System.out.println("Number of zeros in 5!: "+factorialTrailingZeros(5));
		System.out.println("Number of zeros in 12!: "+factorialTrailingZeros(12));
	}
}
