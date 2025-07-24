package arrays;

import java.util.Arrays;

/*
 * Algorithm refer here:
 * https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 */
public class ArrayPermutation {
	/*
	 * This method prints all the possible permutations of the array.
	 * Refer: https://www.youtube.com/watch?v=f2ic2Rsc9pU&t=32s&ab_channel=takeUforward
	 */
	public static void arrayPermutations(int[] arr, int n, int x) {
		if(x == n ) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=x; i<n; i++) {
			swap(arr,x,i);
			arrayPermutations(arr, n, x+1);
			swap(arr,x,i);
		}
	}
	
	/*
	 * next_permutation : find next lexicographically greater permutation
	 * refer: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
	 */
	public static void nextPermutation(int[] arr) {
		int n = arr.length;
		int ind = -1;
		
		for(int i=n-2; i>=0; i--) {
			if(arr[i] < arr[i+1]) {
				ind = i;
				break;
			}
		}
		
		if(ind != -1) {
			for(int i=n-1; i>ind; i--) {
				if(arr[i] > arr[ind]) {
					swap(arr, ind, i);
					break;
				}
			}
		}
		
		int l = ind+1;
		int r = n-1;
		while(l<r) {
			swap(arr,l,r);
			l++;
			r--;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		System.out.println("All permutaions: ");
		arrayPermutations(arr, 4, 0);
		
		nextPermutation(arr);
		System.out.println("Next permutaion: " + Arrays.toString(arr));
	}
}
