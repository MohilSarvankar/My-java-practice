package SearchingAlgorithms;

import java.util.Arrays;

public class InfiniteBinarySearch {

	public static void main(String[] args) {
		int arr[] = {2,4,6,7,10,25,24,36,21,28,27,8,1,50,58,57,53,84,83,85,74,65,90,5};
		Arrays.sort(arr);	
		System.out.println("Sorted array: " + Arrays.toString(arr));
		
		int key = 10;
		System.out.println("Key: " + key);
		
		int index = infiniteBinarySearch(arr, key);
		if(index==-1) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element location: " + index);
		}
	}
	
	public static int infiniteBinarySearch(int[] arr, int key) {
		int l = 0;
		int h = 1;
		
		while(arr[h]<key) {
			l = h;
			h = h*2;
		}
		
		return binarySearch(arr, key, l , h);
	}
	
	public static int binarySearch(int[] arr, int key, int l, int h) {
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
