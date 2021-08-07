package HashSetApplication;

import java.util.HashSet;
import java.util.Set;

public class DistinctElements {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,1,2,3};
		
		int distinct = countDistinctElements(arr);
		
		System.out.println("Number of distinct elements: " + distinct);
	}
	
	public static int countDistinctElements(int[] arr) {
		int n = arr.length;
		Set<Integer> elements = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			elements.add(arr[i]);
		}
		
		return elements.size();
	}

}
