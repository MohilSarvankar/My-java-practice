package arrays;

import java.util.Arrays;

/*
 * Given an integer array arr, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and returns its sum and prints the subarray.
 * refer: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
 */
public class KadanesAlgorithm {
	
	//Brute force approach
	public static void maxSubarraySum1(int[] arr) {
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum += arr[k];
				}
				if(max < sum) {
					max = sum;
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("Max subarray sum is: "+ max);
		System.out.println("Subarray: "+ Arrays.toString(Arrays.copyOfRange(arr, start, end+1)));
	}
	
	//Better approach
	public static void maxSubarraySum2(int[] arr) {
		int max = Integer.MIN_VALUE;
		int n = arr.length;
		int start = 0;
		int end = 0;
		
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += arr[j];
				if(sum > max) {
					max = sum;
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("Max subarray sum is: "+ max);
		System.out.println("Subarray: "+ Arrays.toString(Arrays.copyOfRange(arr, start, end+1)));
	}
	
	//Optimal approach
	public static void maxSubarraySum3(int[] arr) {
		int max = Integer.MIN_VALUE;
		int n = arr.length;
		int sum = 0;
		int start = 0;
		int end = 0;
		
		for(int i=0; i<n; i++) {
			sum += arr[i];
			
			if(sum > max) {
				max = sum;
				end = i;
			}
			
			if(sum < 0) {
				sum = 0;
				start = i+1;
			}
		}
		
		System.out.println("Max subarray sum is: "+ max);
		System.out.println("Subarray: "+ Arrays.toString(Arrays.copyOfRange(arr, start, end+1)));
	}

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		maxSubarraySum1(arr);
		maxSubarraySum2(arr);
		maxSubarraySum3(arr);
	}

}
