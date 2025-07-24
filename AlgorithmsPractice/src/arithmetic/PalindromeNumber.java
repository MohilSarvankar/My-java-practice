package arithmetic;

public class PalindromeNumber {
	public static int reverseNumber(int num) {
		int reverse = 0;
		while(num>0) {
			reverse = reverse*10 + num%10;
			num = num/10;
		}
		System.out.println("Reverse number: "+reverse);
		return reverse;
	}
	
	public static void main(String[] args) {
		int num = 12345;
		int reverse = reverseNumber(num);
		
		if(num == reverse) {
			System.out.println(num + " is palindrome.");
		}
		else {
			System.out.println(num + " is not palindrome.");
		}
	}
}
