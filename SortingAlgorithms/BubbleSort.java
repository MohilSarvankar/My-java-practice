package SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5,6,3,1,2,4};
		int n = arr.length;
		boolean sorted = true;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			
			if(sorted)   //if array is already sorted
				break;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
