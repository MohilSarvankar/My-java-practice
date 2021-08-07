package MathsAlgorithms;

public class TrailingZerosInFactorial {

	public static void main(String[] args) {
		System.out.println(trailingZerosInFactorial(12));
	}
	
	public static int trailingZerosInFactorial(int n) {
		int count = 0;
		
		for(int i=5; i<=n; i=i*5) {
			count = count + n/i;
		}
		
		return count;
	}

}
