package HashMapApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Print number of elements in every window of k elements.
 */
public class DistinctElementsInWindow {

	public static void main(String[] args) {
		int arr[] = {1,2,2,1,3,1,1,3};
		int k = 4;
		
		System.out.println("Given array: " + Arrays.toString(arr));
		System.out.println("Given window: " + k);
		
		System.out.println("\nNumber of distinct elements in every window: ");
		distinctElementsInWindow(arr, k);
	}
	
	public static void distinctElementsInWindow(int arr[], int k) {
		Map<Integer, Integer> window = new HashMap<Integer, Integer>();
		int n = arr.length;
		
		for(int i=0; i<k; i++) {
			window.put(arr[i], window.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(window.size());
		
		for(int i=k; i<n; i++) {
			if(window.get(arr[i-k])==1)
				window.remove(arr[i-k]);
			else
				window.put(arr[i-k], window.get(arr[i-k])-1);
			
			window.put(arr[i], window.getOrDefault(arr[i], 0)+1);
			
			System.out.println(window.size());
		}
	}

}
