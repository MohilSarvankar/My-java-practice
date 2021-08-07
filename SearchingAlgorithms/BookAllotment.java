package SearchingAlgorithms;

/*
 * We have an array indicating no. of pages in every book. k is the no. of students.
 * We have to distribute books in a continuous manner such that the maximum number of pages 
 * read by any student is minimized.
 */

public class BookAllotment {

	public static void main(String[] args) {
		int arr[] = {5,10,10,20,25,30,30};  //pages in each book
		int k = 4;  //no of students
		
		int minPages = minPagesToRead(arr, k);
		
		System.out.println("Minimized maximum pages are: " + minPages);
	}

	public static int minPagesToRead(int[] arr, int k) {
		int min = findMax(arr);
		int max = findSum(arr);
		int res = 0;
		
		while(min <= max) {
			int mid = (min+max)/2;
			
			if(isFeasible(arr,k,mid)) {
				res = mid;
				max = mid - 1;
			}
			else {
				min = mid + 1;
			}
		}
		
		return res;
	}
	
	public static boolean isFeasible(int[] arr, int k, int res) {
		int sum = 0;
		int student = 1;
		
		for(int i=0; i<arr.length; i++) {
			if(sum+arr[i] <= res) {
				sum += arr[i];
			}
			else {
				sum = arr[i];
				student++;
			}
		}
		
		return student <= k;
	}
	
	public static int findMax(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static int findSum(int[] arr) {
		int sum = 0;
		for(int i=0; i< arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}
