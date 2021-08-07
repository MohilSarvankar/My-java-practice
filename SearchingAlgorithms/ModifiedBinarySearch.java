package SearchingAlgorithms;

import java.util.Arrays;

public class ModifiedBinarySearch {

	public static void main(String[] args) {
		int arr[] = {25,27,35,2,3,4,9,10,15,18,20};	
		System.out.println("Sorted and Rotated Array: " + Arrays.toString(arr));
		
		int key = 3;
		System.out.println("Key: " + key);
		
		int index = modifiedBinarySearch(arr, key);
		if(index==-1) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element location: " + index);
		}
	}
	
	public static int modifiedBinarySearch(int[] arr, int key) {
		int l = 0;
		int h = arr.length-1;
		
		while(l<=h) {
			int mid = (l+h)/2;
			if(key == arr[mid])
				return mid;
			
			//left part is sorted
			if(arr[l]<arr[mid]) {
				if(arr[l] <= key && key < arr[mid])
					h = mid - 1;
				else
					l = mid + 1;
			}
			//right part is sorted
			else {
				if(arr[mid] < key && key <= arr[h])
					l = mid + 1;
				else
					h = mid - 1;
			}
		}
		
		return -1;
	}

}
