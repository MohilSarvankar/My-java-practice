package arithmetic;

public class PrimeNumbers {
	
	//normal method
	public static void primeNumbers(int n) {
		for(int i=1; i<=n; i++) {
			int count = 0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	//normal method imporoved
	public static void primeNumbersNew(int n) {
		loop1: for(int i=2; i<=n; i++) {
			if(i==2) {
				System.out.print(i + " ");
				continue loop1;
			}
			if(i%2==0) continue loop1;
			
			loop2: for(int j=3; j<=i; j++) {
				if(j==i) {
					System.out.print(i + " ");
				}
				if(i%j==0) break loop2;
			}
		}
		System.out.println();
	}
	
	//sieve of eratosthenes
	public static void sieveOfEratosthenes(int n) {
		boolean[] arr = new boolean[n+1];
		arr[0] = true;
		arr[1] = true;
		
		for(int i=2; i*i<=n; i++) {
			if(arr[i]==false) {
				for(int j=i+i; j<=n; j=j+i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i=0; i<=n; i++) {
			if(arr[i]==false) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//Print prime numbers in the range 0 to n
		int n = 100;
		primeNumbers(n);
		primeNumbersNew(n);
		sieveOfEratosthenes(n);
	}

}
