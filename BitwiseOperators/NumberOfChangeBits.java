package BitwiseOperators;

public class NumberOfChangeBits {
	public static void main(String[] args) {
		System.out.println("Number of bits require to change for converting a to b: ");
		System.out.println(bitChange(10, 15));
	}
	
	public static int bitChange(int a, int b) {
		int res = 0;
		int temp = a^b;
		
		while(temp!=0) {
			temp = temp & (temp-1);
			res++;
		}
		
		return res;
	}
}
