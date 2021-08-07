package SearchingAlgorithms;

import java.util.Arrays;

public class BinarySearchWithIteration {

	public static void main(String[] args) {
		int arr[] = {2,4,6,7,8,1,5};
		Arrays.sort(arr);	
		System.out.println("Sorted array: " + Arrays.toString(arr));
		
		int key = 10;
		System.out.println("Key: " + key);
		
		int index = binarySearch(arr, key);
		if(index==-1) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element location: " + index);
		}
	}
	
	public static int binarySearch(int[] arr, int key) {
		int l=0, h=arr.length-1;
		int mid;
		
		while(l<=h) {
			mid = (l+h)/2;
			
			if(key == arr[mid])
				return mid;
			else if(key < arr[mid])
				h = h - 1;
			else
				l = l + 1;
		}
		
		return -1;
	}

}
