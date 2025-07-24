package arrays;

import java.util.Arrays;

/*
 * Find the duplicate in an array of N+1 integers
 * Refer: https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/
 */
public class FindDuplicateInteger {

	//Using sorting
	public static int findDuplicate1(int[] arr) {
		int n = arr.length;
		int duplicate = 0;
		Arrays.sort(arr);
		
		for(int i=0; i<n-1; i++) {
			if(arr[i] == arr[i+1]) {
				duplicate = arr[i];
				break;
			}
		}
		
		return duplicate;
	}
	
	//Using frequency array
	public static int findDuplicate2(int[] arr) {
		int n = arr.length;
		int[] freqArr = new int[n];
		int duplicate = 0;
		
		for(int i=0; i<n; i++) {
			if(freqArr[arr[i]] == 0) {
				freqArr[arr[i]] = 1;
			}
			else {
				duplicate = arr[i];
				break;
			}
		}
		
		return duplicate;
	}
	
	//Linked List cycle method
	public static int findDuplicate3(int[] arr) {
		int s = 0;
		int f = 0;
		int duplicate = 0;
		
		do {
			s = arr[s];
			f = arr[arr[f]];
		}while(s != f);
		
		f = 0;
		while(f != s) {
			f = arr[f];
			s = arr[s];
		}
		duplicate = s;
		return duplicate;
	}
	
	public static void main(String[] args) {
		int[] arr = {6,1,3,4,2,7,2,5};
//		System.out.println("Dupliacte element using findDuplicate1: "+ findDuplicate1(arr));
		System.out.println("Dupliacte element using findDuplicate2: "+ findDuplicate2(arr));
		System.out.println("Dupliacte element using findDuplicate3: "+ findDuplicate3(arr));
	}

}
