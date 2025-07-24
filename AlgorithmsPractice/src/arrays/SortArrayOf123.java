package arrays;

import java.util.Arrays;

/*
 * Sort an array of 0s, 1s and 2s
 * Given an array consisting of only 0s, 1s, and 2s. 
 * Write a program to in-place sort the array without using inbuilt sort functions. 
 * refer: https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
 */
public class SortArrayOf123 {
	
	/*
	 * Brute force approach
	 * We can use merge sort here.
	 */
	public static void sortArray1(int[] arr) {
		Arrays.sort(arr);
	}
	
	//Better approach
	public static void sortArray2(int[] arr) {
		int n = arr.length;
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i] == 0)
				count0++;
			else if(arr[i] == 1)
				count1++;
			else if(arr[i] == 2)
				count2++;
		}
		
		for(int i=0; i<n; i++) {
			if(i < count0)
				arr[i] = 0;
			else if(i < count0 + count1)
				arr[i] = 1;
			else
				arr[i] = 2;
		}
	}

	/*
	 * Optimal soluation
	 * variation of the popular Dutch National flag algorithm
	 */
	public static void sortArray3(int[] nums) {
		int n = nums.length;
		int low = 0;
		int mid = 0;
		int high = n-1;
		
		while(mid <= high){
			if(nums[mid] == 0) {
				swap(nums,low,mid);
				low++;
				mid++;
			}
			else if(nums[mid] == 1) {
				mid++;
			}
			else if(nums[mid] == 2) {
				swap(nums,mid,high);
				high--;
			}
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,0,2,1,1,0};
//		sortArray1(arr);
//		sortArray2(arr);
		sortArray3(arr);
		System.out.println("Sorted array: "+Arrays.toString(arr));
	}

}
