package MathsAlgorithms;

public class PalindromNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrom(212));
	}

	public static boolean isPalindrom(int n) {
		int reverse = 0;
		int temp = n;
		
		while(temp!=0) {
			reverse = reverse*10 + temp%10;
			temp = temp/10;
		}
		
		return reverse==n;
	}
}
