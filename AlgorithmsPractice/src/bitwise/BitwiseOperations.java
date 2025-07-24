package bitwise;

public class BitwiseOperations {
	public static void main(String[] args) {
		//divide and multiply by 2
		System.out.println(4<<1);
		System.out.println(4>>1);
		
		//even odd
		int num = 5;
		if((num&1) == 0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
		
		//swapping 2 numbers
		int a = 4;
		int b = 6;
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a = "+a+ " and b = "+b);
		
		//finding 3rd bit of number
		int n = 16;
		if((n&(1<<3))==0) { 
			System.out.println("3rd bit is 0");
		}
		else {
			System.out.println("3rd bit is 1");
		}
		
		//setting 3rd bit of number
		System.out.println("setting 3rd bit of 16: "+(n|(1<<3)));
		
		//clearing 3rd bit of number
		System.out.println("clearing 3rd bit of 15: "+ (15&(~(1<<3))));
		
		numberOfBitsToChange(10, 31);
		//10 - 01010
		//31 - 11111
	}
	
	//number of bits required to change from a to b
	public static void numberOfBitsToChange(int a, int b) {
		int n = a^b;
		int count = 0;
		while(n!=0) {
			n = n&(n-1);
			count++;
		}
		System.out.println("Number of bits to change from "+a+" to "+b+" = "+count);
	}
}
