package recurssion;

public class WaysInMatrix {
	/*
	 * We have to find number of ways out in a mxn matrix
	 * where only bottom and right movement is allowed.
	 * 
	 *  Start -> | | | |
	 *           | | | |
	 *           | | | |  <- stop
	 */
	
	public static int noOfWaysOutInMatrix(int m, int n) {
		if(m==1 || n==1) return 1;
		return noOfWaysOutInMatrix(m, n-1) + noOfWaysOutInMatrix(m-1, n);
	}
	
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		System.out.println("Number of ways out : " + noOfWaysOutInMatrix(m,n));
	}
}
