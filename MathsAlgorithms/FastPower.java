package MathsAlgorithms;

public class FastPower {

	public static void main(String[] args) {
		System.out.println(fastPower(20, 6));
	}
	
	public static long fastPower(int a, int b) {
		long res = 1;
		
		while(b>0) {
			if((b&1) != 0) {
				res = res * a;
			}
			
			a = a*a;
			b = b>>1;
		}
		
		return res;
	}

}
