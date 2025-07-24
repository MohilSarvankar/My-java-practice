package heap;

import java.util.Arrays;

/*
 * refer:
 * https://youtu.be/ywx-Onrdx4U?si=S8-nP3H51SI5i-JS
 */
public class HeapInsertDelete {
	
	public static int[] insertInHeap(int[] heapArr, int value) {
		int n = heapArr.length + 1;
		heapArr = Arrays.copyOf(heapArr, n);
		heapArr[n-1] = value;
		int i = n-1;
		
		while(i > 0) {
			int parent = (i-1)/2;
			if(heapArr[i] > heapArr[parent]) {
				swap(heapArr, i, parent);
				i = parent;
			}
			else {
				return heapArr;
			}
		}
		
		return heapArr;
	}
	
	//Always delete root node
	public static int[] deleteFromHeap(int[] heapArr) {
		int n = heapArr.length;
		heapArr[0] = heapArr[n-1];
		heapArr = Arrays.copyOfRange(heapArr, 0, n-1);
		n = n-1;
		int i = 0;
		
		while(i<n) {
			int left = 2*i + 1;
			int right = 2*i + 2;
			int larger = 0;
			
			if(left < n && right < n)
				larger = heapArr[left] > heapArr[right] ? left : right;
			else if(left < n)
				larger = left;
			else
				return heapArr;
			
			if(heapArr[larger] > heapArr[i]) {
				swap(heapArr, larger, i);
				i = larger;
			}
			else {
				return heapArr;
			}
		}
		
		return heapArr;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] heapArr = {50,30,40,10,5,20,30};
		heapArr = insertInHeap(heapArr, 60);
		System.out.println("After inserting 60: " + Arrays.toString(heapArr));
		heapArr = insertInHeap(heapArr, 45);
		System.out.println("After inserting 45: " + Arrays.toString(heapArr));
		
		heapArr = deleteFromHeap(heapArr);
		System.out.println("After deleting: " + Arrays.toString(heapArr));
	}
}
