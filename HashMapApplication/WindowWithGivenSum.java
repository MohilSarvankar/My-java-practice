package HashMapApplication;
/*
 * Find the subarray with the given sum.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WindowWithGivenSum {

	public static void main(String[] args) {
		int[] arr = {10,15,-5,15,-10,5};
		int sum = 5;
		
		System.out.println("Given array: " + Arrays.toString(arr));
		System.out.println("Given Sum: " + sum);
		
		int n = arr.length;
		int curSum = 0;
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		
		int start = 0, stop = -1;
		
		for(int i=0; i<n; i++) {
			curSum += arr[i];
			
			if(curSum == sum) {
				start = 0;
				stop = i;
				break;
			}
			
			if(sumMap.containsKey(curSum - sum)) {
				start = sumMap.get(curSum-sum)+1;
				stop = i;
				break;
			}
			
			sumMap.put(curSum, i);
		}
		
		System.out.println("\nOuput:");
		if(stop == -1) {
			System.out.println("Given sum not found");
		}
		else {
			System.out.println("Start index: "+ start + "\nStop index: "+ stop);
		}
	}

}
