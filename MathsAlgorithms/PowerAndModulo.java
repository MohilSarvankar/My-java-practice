package MathsAlgorithms;

public class PowerAndModulo {
	public static void main(String[] args) {
		System.out.println(powerAndModulo(2153, 6254, 100000));
	}
	
	public static long powerAndModulo(int a, int b, int n) {
		long res = 1;
		
		while(0<b) {
			if((b&1) != 0) {
				res = (res%n * a%n)%n;
			}
			
			a = (a%n * a%n)%n;
			b = b>>1;
		}
		
		return res;
	}
}
