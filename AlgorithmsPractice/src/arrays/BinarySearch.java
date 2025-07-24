package arrays;

public class BinarySearch {
	
	/*
	 * Normal binary search using while lop
	 */
	public static int binarySearch(int[] arr, int value) {
		int low = 0;
		int high = arr.length - 1;
		
		if(value == arr[low]) return low;
		if(value == arr[high]) return high;
		
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == value) 
				return mid;
			if(value > arr[mid])
				low = mid + 1;
			if(value < arr[mid])
				high = mid - 1;
		}
		
		return -1;
	}
	
	/*
	 * Binary search in infinite array.
	 * We can't find length of array directly.
	 */
	public static int binarySearchInfinite(int[] arr, int value) {
		int low = 0;
		int high = 1;
		while(arr[high] < value) {
			low = high;
			high = high * 2;
		}
		
		if(value == arr[low]) return low;
		if(value == arr[high]) return high;
		
		while(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == value) 
				return mid;
			if(value > arr[mid])
				low = mid + 1;
			if(value < arr[mid])
				high = mid - 1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7,9,12,14,16,20};
		System.out.println("Index of 14: " + binarySearch(arr, 14));
		System.out.println("Index of 14 in infinite array: "+binarySearchInfinite(arr, 14));
	}

}
