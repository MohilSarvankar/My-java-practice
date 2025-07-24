package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Finding majority elements in an array. 
 * If given array of size N then the element should occur > N/2 times.
 */
public class ManjorityElements {
	/*
	 * Brute force approach using nested for loops.
	 * Time complexity: O(n^2)
	 */
	public static int findMajorityElements1(int[] arr) {
		int res = 0;
		int n = arr.length;
		for(int i=0; i<n; i++) {
			int count = 0;
			for(int j=0; j<n; j++) {
				if(arr[i] == arr[j]) count++;
			}
			if(count > n/2) {
				res = arr[i];
				break;
			}
		}
		return res;
	}
	
	/*
	 * We will sort the array first. Then we will linearly traverse to find the majority element.
	 * Time Complexity: O(NlogN) + O(N)
	 */
	public static int findMajorityElements2(int[] arr) {
		int res = 0;
		int n = arr.length;
		Arrays.sort(arr);
		
		int ocr = 1;
		for(int i=0; i<n-1; i++) {
			if(arr[i] == arr[i+1]) {
				ocr ++;
			}
			if(ocr > n/2) {
				res = arr[i];
				break;
			}
			if(arr[i] != arr[i+1]) {
				ocr = 1;
			}
		}
		return res;
	}
	
	/*
	 * Here we will use hashmap to store each value and its count. 
	 * Then again iterate through hashmap to find the majority element.
	 * Time Complexity: O(N)
	 * Space Complexity: O(N)
	 */
	public static int findMajorityElements3(int[] arr) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
		for(Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() > n/2) {
				res = entry.getKey();
				break;
			}
		}
		return res;
	}
	
	/*
	 * Initially we store first element and count as 1. 
	 * We linearly traverse, if next element is same then count++ else count--.
	 * If count = 0 then we change the stored element.
	 * Time Complexity: O(N)
	 * Space: O(1)
	 */
	public static int findMajorityElements4(int[] arr) {
		int temp = arr[0];
		int count = 1;
		int n = arr.length;
		int res = 0;
		
		for(int i=1;i<n;i++) {
			if(arr[i]==temp) {
				count++;
			}
			else {
				count--;
				if(count==0) temp = arr[i];
			}
		}
		
		int maj_count = 0;
		if(count > 0) {
			for(int i=0;i<n;i++) {
				if(temp == arr[i]) maj_count++;
			}
		}
		
		if(maj_count > n/2) res = temp;
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,2,4,2,1,1,2};
		System.out.println("Majority element using 1st function: " + findMajorityElements1(arr));
		System.out.println("Majority element using 2nd function: " + findMajorityElements2(arr));
		System.out.println("Majority element using 3rd function: " + findMajorityElements3(arr));
		System.out.println("Majority element using 4th function: " + findMajorityElements4(arr));
	}
}
