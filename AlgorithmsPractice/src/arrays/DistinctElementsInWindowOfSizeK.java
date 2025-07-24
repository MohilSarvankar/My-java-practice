package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Refer:
 * https://www.youtube.com/watch?v=j48e8ac7r20&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=29&t=339s&ab_channel=AnujBhaiya
 */

public class DistinctElementsInWindowOfSizeK {
	
	//Brute force approach 1
	public static int[] findDistinctElements1(int[] arr, int k) {
		int n = arr.length;
		int[] ans = new int[n-k+1];
		
		for(int i=0; i<n-k+1; i++) {
			int count = 0;
			for(int j=i; j<i+k; j++) {
				count++;
				for(int x=j-1; x>=i; x--) {
					if(arr[x] == arr[j]) {
						count--;
						break;
					}	
				}
			}
			ans[i] = count;
		}
		
		return ans;
	}
	
	//Brute force approach 2
	public static int[] findDistinctElements2(int[] arr, int k) {
		int n = arr.length;
		int[] ans = new int[n-k+1];
		
		for(int i=0; i<n-k+1; i++) {
			int count = 0;
			for(int j=i; j<i+k; j++) {
				boolean found = false;
				for(int x=j-1; x>=i; x--) {
					if(arr[x] == arr[j]) {
						found = true;
						break;
					}	
				}
				if(!found)
					count++;
			}
			ans[i] = count;
		}
		
		return ans;
	}
	
	//Optimal approach 1
	public static int[] findDistinctElements3(int[] arr, int k) {
		int n = arr.length;
		int[] ans = new int[n-k+1];
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
			
			if(i-k+1 >= 0) {
				ans[i-k+1] = map.size();
				if(map.get(arr[i-k+1]) > 1) {
					map.put(arr[i-k+1], map.get(arr[i-k+1])-1);
				}
				else {
					map.remove(arr[i-k+1]);
				}
			}
		}
		
		return ans;
	}
	
	//Optimal approach 2 (Same as before but with some modification)
	/*
	 * refer:
	 * https://www.youtube.com/watch?v=j48e8ac7r20&list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p&index=29&t=339s&ab_channel=AnujBhaiya
	 */
	public static int[] findDistinctElements4(int[] arr, int k) {
		int n = arr.length;
		int[] ans = new int[n-k+1];
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		ans[0] = map.size();
		
		for(int i=k; i<n; i++) {
			if(map.get(arr[i-k]) == 1) {
				map.remove(arr[i-k]);
			}
			else {
				map.put(arr[i-k], map.get(arr[i-k])-1);
			}
			
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			ans[i-k+1] = map.size();
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,1,3,1,1,3};
		int k = 4;
//		int[] ans = findDistinctElements1(arr, k);
//		int[] ans = findDistinctElements2(arr, k);
//		int[] ans = findDistinctElements3(arr, k);
		int[] ans = findDistinctElements4(arr, k);
		System.out.println("No of distinct elements: " + Arrays.toString(ans));
	}
	
}
