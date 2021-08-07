package SearchingAlgorithms;

import java.util.Arrays;

public class BinarySearchWithRecurssion {

	public static void main(String[] args) {
		int arr[] = {2,4,6,7,8,1,5};
		int n = arr.length;
		
		Arrays.sort(arr);	
		System.out.println("Sorted array: " + Arrays.toString(arr));
		
		int key = 5;
		System.out.println("Key: " + key);
		
		int index = recurssiveBinarySearch(arr, key, 0, n-1);
		
		if(index==-1) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element location: " + index);
		}
	}
	
	public static int recurssiveBinarySearch(int[] arr, int key, int l, int h) {
		if(l<=h) {
			int mid = (l+h)/2;
			
			if(key == arr[mid])
				return mid;
			
			else if(key < arr[mid]) 
				return recurssiveBinarySearch(arr, key, l, mid-1);
						
			else
				return recurssiveBinarySearch(arr, key, mid+1, h);
		}
		return -1;
	}

}
