package HashSetApplication;

import java.util.HashSet;
import java.util.Set;

public class UnionOfArrays {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {2,3,4,7,8,9};
		
		int unionSize = countUnionSize(arr1, arr2);
		System.out.println("Size of union of 2 arrays: " + unionSize);
	}
	
	public static int countUnionSize(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		Set<Integer> elements = new HashSet<>();
		
		for(int i=0; i<n1; i++) {
			elements.add(arr1[i]);
		}
		
		for(int i=0; i<n2; i++) {
			elements.add(arr2[i]);
		}
		
		return elements.size();
	}

}
