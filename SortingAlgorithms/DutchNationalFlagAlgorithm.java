package SortingAlgorithms;

import java.util.Arrays;

public class DutchNationalFlagAlgorithm {
	public static void main(String[] args) {
		int[] arr = {0,1,2,0,2,1,1,0,1};
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		int temp = 0;
		
		while(mid <= high) {
			switch(arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
				break;
				
			case 1: 
				mid++;
				break;
				
			case 2:
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	} 
}
