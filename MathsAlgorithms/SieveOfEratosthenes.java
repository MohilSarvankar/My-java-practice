package MathsAlgorithms;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		boolean[] isPrime = seiveOfEratosthenes(12);
		
		for(int i=0; i<=12; i++) {
//			System.out.println(i+ " " + isPrime[i]);
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean[] seiveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2;i*i<n;i++) {
			for(int j=2*i; j<=n; j=j+i) {
				isPrime[j] = false;
			}
		}
		
		return isPrime;
	}

}
