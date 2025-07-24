package bitwise;

import java.util.Arrays;

public class XorProblems {
	public static void main(String[] args) {
		nonRepeatedElement1();
		nonRepeatedElement2();
		nonRepeatedElement3();
	}
	
	//Finding non repeated number where other numbers are repeated 2 times
	public static void nonRepeatedElement1() {
		System.out.println("1 non repeated elemet other repeat 2 times");
		int[] arr = {2,5,8,5,2,8,3};
		int res = 0;
		for(int i: arr) {
			res = res^i;
		}
		System.out.println("Non repeated number: "+res);
	}
	
	//Finding 2 non repeated number where other numbers are repeated 2 times
	public static void nonRepeatedElement2() {
		System.out.println("\n2 non repeated elemet other repeat 2 times");
		int[] arr = {2,5,8,5,7,2,8,3};
		int num = 0;
		for(int i: arr) {
			num = num^i;
		}
		//num = 7^3 = 4 = 0100
		int temp = 0;
		int res1 = num;
		int res2 = num;
		
		for(int i: arr) {
			temp = num&i;
			if(temp == 0) {
				res1 = res1^i;
			}
			else {
				res2 = res2^i;
			}
		}

		System.out.println("1st non repeated element: "+res1);
		System.out.println("2nd non repeated element: "+res2);
	}
	
	//Finding non repeated element where other elements are repeated 3 times
	public static void nonRepeatedElement3() {
		System.out.println("\n1 non repeated elemet other repeat 3 times");
		int[] arr = {9,3,5,3,6,5,9,3,5,9};
		int[] bitArr = new int[32];
		
		for(int i: arr) {
			int j = 0;
			while(i!=0) {
				bitArr[j]+=i%2;
				i = i/2;
				j++;
			}
		}
		
		int res = 0;
		for(int i=0;i<32;i++) {
			bitArr[i] = bitArr[i]%3;  //since other repeat 3 times
			res = res + (int)Math.pow(2, i)*bitArr[i];
		}
		
		System.out.println("Non repeated number: "+res);
	}
}
