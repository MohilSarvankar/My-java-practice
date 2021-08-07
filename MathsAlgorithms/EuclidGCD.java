package MathsAlgorithms;

public class EuclidGCD {

	public static void main(String[] args) {
		System.out.println(euclidGCD(20, 45));
	}
	
	public static int euclidGCD(int a, int b) {
		if(a%b == 0)
			return b;
		return euclidGCD(b, a%b);
	}

}
