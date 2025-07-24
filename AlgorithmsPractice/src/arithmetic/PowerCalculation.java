package arithmetic;

public class PowerCalculation {

	//normal method for power calculation: a multiplied b times
	public static int normalPower(int a, int b) {
		int res = 1;
		for(int i=1;i<=b;i++) {
			res *= a;
		}
		return res;
	}
	
	//modified method for fast calculation
	public static int fastPower(int a, int b) {
		int res = 1;
		while(b>0) {
			if((b&1) != 0) {
				res = res*a;
			}
			a = a*a;
			b = b>>1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("5^10 normal method: "+normalPower(5, 10));
		System.out.println("5^10 fast method: "+fastPower(5, 10));
	}

}
