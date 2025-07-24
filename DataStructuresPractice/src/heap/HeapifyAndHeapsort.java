package heap;

import java.util.Arrays;

public class HeapifyAndHeapsort {
	
	public static void heapify(int[] a, int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l <= n && a[l] > a[largest])
			largest = l;
		
		if(r <= n && a[r] > a[largest])
			largest = r;
		
		if(largest != i) {
			swap(a, largest, i);
			heapify(a, n, largest);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void buildHeap(int[] a, int n) {
		for(int i=n/2; i>=0; i--) {
			heapify(a, n, i);
		}
		System.out.println("Heap: "+ Arrays.toString(a));
	}
	
	public static void heapSort(int[] a) {
		int n = a.length;
		buildHeap(a, n-1);
		for(int i=n-1; i>0; i--) {
			swap(a,0,i);
			heapify(a, i-1, 0);
		}
	}

	public static void main(String[] args) {
		int[] a = {20,10,30,5,50,40};
		heapSort(a);
		System.out.println("Sorted array: " + Arrays.toString(a));
	}

}
