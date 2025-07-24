package arrays;

/*
 * Find the repeating and missing numbers
 * Refer: https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
 */
public class FindRepetativeAndMissingNumber {

	//Brute force approach
	public static int[] repeatingAndMissingNumber1(int[] arr) {
		int[] ans = new int[2];
		int n = arr.length;
		int repeating = -1;
		int missing = -1;
		
		for(int i=1; i<=n; i++) {
			int count = 0;
			for(int j=0; j<n; j++) {
				if(arr[j] == i) 
					count++;
			}
			if(count == 2)
				repeating = i;
			if(count == 0)
				missing = i;
			if(repeating != -1 && missing != -1)
				break;
		}
		
		ans[0] = repeating;
		ans[1] = missing;
		
		return ans;
	}
	
	//Better appraoch
	public static int[] repeatingAndMissingNumber2(int[] arr) {
		int[] ans = new int[2];
		int missing = -1;
		int repeating = -1;
		int n = arr.length;
		int[] freqArr = new int[n+1];
		
		for(int i=0; i<n; i++) {
			freqArr[arr[i]]++;
		}
		
		for(int i=1; i<n+1; i++) {
			if(freqArr[i] == 0)
				missing = i;
			
			if(freqArr[i] == 2)
				repeating = i;
			
			if(missing!=-1 && repeating!=-1)
				break;
		}
		
		ans[0] = repeating;
		ans[1] = missing;
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,2,5,3};
		
//		int[] ans = repeatingAndMissingNumber1(arr);
		int[] ans = repeatingAndMissingNumber2(arr);
		
		System.out.println("Reapeating number: "+ans[0]);
		System.out.println("Missing number: "+ans[1]);
	}

}
