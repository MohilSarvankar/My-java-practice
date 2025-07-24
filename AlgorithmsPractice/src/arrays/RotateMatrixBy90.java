package arrays;

/*
 * Rotate Image by 90 degree
 * Refer (for clockwise): https://takeuforward.org/data-structure/rotate-image-by-90-degree/
 * Refer (for anti-clockwise): https://takeuforward.org/data-structure/rotate-matrix-anti-clockwise-by-90-degree/
 */
public class RotateMatrixBy90 {
	
	//Brute force approach
	public static int[][] rotateClockwise1(int[][] arr) {
		int n = arr.length;
		int[][] temp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[j][n-1-i] = arr[i][j];
			}
		}

		return temp;
	}
	
	//Optimal Approach
	public static void rotateClockwise2(int[][] arr) {
		int n = arr.length;
		int temp = 0;
		
		//Taking transpose (Changing rows into columns)
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		//Making rows reverse
		for(int i=0; i<n; i++) {
			for(int j=0; j<n/2; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][n-1-j];
				arr[i][n-1-j] = temp;
			}
		}
	}
	
	//Brute force approach
	public static int[][] rotateAntiClockwise1(int[][] arr){
		int n = arr.length;
		int[][] temp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[n-1-j][i] = arr[i][j];
			}
		}
		
		return temp;
	}
	
	//Optimal approach
	public static void rotateAntiClockwise2(int[][] arr){
		int n = arr.length;
		int temp = 0;
		
		//Taking transpose (Changing rows into columns)
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		
		//Making columns reverse
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[n-1-i][j];
				arr[n-1-i][j] = arr[i][j];
			}
		}
	}
	
	public static void printMatrix(int[][] arr) {
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Original array: ");
		printMatrix(arr);
		
		int[][] rotatedMatrix1 = rotateClockwise1(arr);
		System.out.println("\nRotated matrix clockwise 90 degree: ");
		printMatrix(rotatedMatrix1);
		
		rotateClockwise2(arr);
		System.out.println("\nRotated matrix clockwise 90 degree: ");
		printMatrix(arr);
		
		int[][] rotatedMatrix2 = rotateAntiClockwise1(arr);
		System.out.println("\nRotated matrix anti clockwise 90 degree: ");
		printMatrix(rotatedMatrix2);
		
		rotateAntiClockwise2(arr);
		System.out.println("\nRotated matrix anti clockwise 90 degree: ");
		printMatrix(arr);
	}

}
