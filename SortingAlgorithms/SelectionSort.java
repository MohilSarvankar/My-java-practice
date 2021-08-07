package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {5,6,3,1,2,4};
		int n = arr.length;
		
		for(int i=0; i<n-1; i++) {
			int min = i;
			for(int j=i+1; j<n; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			
			if(min != i) {            //if current position element is not minimum then only swap
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
