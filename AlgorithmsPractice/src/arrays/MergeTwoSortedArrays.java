package arrays;

import java.util.Arrays;

/*
 * Refer: https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
 */
public class MergeTwoSortedArrays {
	
	/*
	 * Brute force approach
	 * Using extra space
	 */
	public static void mergeArrays1(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] arr3 = new int[n+m];
		int i=0, j=0, k=0;
		
		while(i<n && j<m) {
			if(arr1[i] <= arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			}
			else {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i<n) {
			arr3[k] = arr1[i];
			i++;
			k++;
		}
		
		while(j<m) {
			arr3[k] = arr2[j];
			j++;
			k++;
		}
		
		k = 0;
		while(k<n+m) {
			if(k<n) {
				arr1[k] = arr3[k];
			}
			else {
				arr2[k-n] = arr3[k];
			}
			k++;
		}
	}
	
	//Optimal approach 1
	public static void mergeArrays2(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int l = n-1;
		int r = 0;
		int temp = 0;
		
		while(l>=0 && r<m) {
			if(arr1[l] > arr2[r]) {
				temp = arr1[l];
				arr1[l] = arr2[r];
				arr2[r] = temp;
				l--;
				r++;
			}
			else {
				break;
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
	
	//Optimal approach 2
	public static void mergeArrays3(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int gap = (int) Math.ceil((n+m)/2.0);
		int l = 0;
		int r = gap;
		int temp = 0;
		
		while(gap > 0) {
			l = 0;
			r = gap;
			while(r<n+m) {
				if(l<n && r<n && arr1[l] > arr1[r]) {
					temp = arr1[l];
					arr1[l] = arr1[r];
					arr1[r] = temp;
				}
				else if(l<n && r>=n && arr1[l] > arr2[r-n]) {
					temp = arr1[l];
					arr1[l] = arr2[r-n];
					arr2[r-n] = temp;
				}
				else if(l>=n && r>=n && arr2[l-n] > arr2[r-n]) {
					temp = arr2[l-n];
					arr2[l-n] = arr2[r-n];
					arr2[r-n] = temp;
				}
				l++;
				r++;
			}
			gap = gap/2;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,4,5};
		int[] arr2 = {2,3,8,9};
		
//		mergeArrays1(arr1, arr2);
//		mergeArrays2(arr1, arr2);
		mergeArrays3(arr1, arr2);
		
		System.out.println("Sorted arrays: ");
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
