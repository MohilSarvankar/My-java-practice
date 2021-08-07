package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {5,6,3,1,2,4};
		int n = arr.length;
		
		quickSort(arr, 0, n-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int arr[], int l, int h) {
		if(l<h) {
			int pivotIndex = partition(arr, l, h);
			quickSort(arr, l, pivotIndex-1);
			quickSort(arr, pivotIndex+1, h);
		}
	}
	
	public static int partition(int arr[], int l, int h) {
		int i = l;
		int j = h;
		int pivot = arr[l];
		
		while(i<j) {
			while(pivot >= arr[i])
				i++;
			while(pivot<arr[j])
				j--;
			if(i<j)
				swap(arr,i,j);
		}
		
		swap(arr,j,l);
		
		return j;
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
