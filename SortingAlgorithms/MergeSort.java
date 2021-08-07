package SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = {5,6,3,1,2,4};
		int n = arr.length;
		
		mergeSort(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int arr[], int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr,l,mid,r);
		}
	}
	
	public static void merge(int arr[], int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int k = l;
		int [] temp = new int[arr.length];
		
		while(i<=mid && j<=r) {
			if(arr[i]<arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i>mid) {
			while(j<=r) {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		else {
			while(i<=mid) {
				temp[k] = arr[i];
				i++;
				k++;
			}
		}
		
		for(k=l;k<=r;k++) {
			arr[k] = temp[k];
		}
	}
}
