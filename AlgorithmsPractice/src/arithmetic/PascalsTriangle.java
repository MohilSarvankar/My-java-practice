package arithmetic;

import java.util.ArrayList;
import java.util.List;

/*
 * Algorithm refer here:
 * https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
 */
public class PascalsTriangle {
	
	/*
	 * Variation 1: Given row number r and column number c. 
	 * Print the element at position (r, c) in Pascal’s triangle.
	 * r -> row & c -> column
	 * So element is (r-1)C(c-1)
	 */
	public static int pascalTriangleElement1(int r, int c) {
		int res = 1;
		int n = r-1;
		for(int i=1; i<c; i++) {
			res = (res*n)/i;
			n--;
		}
		return res;
	}
	
	/*
	 * Variation 1: Given row number r and column number c. 
	 * Print the element at position (r, c) in Pascal’s triangle.
	 * My method: using recursion
	 */
	public static int pascalTriangleElement2(int r, int c) {
		if(r==c || r==1 || c==1) 
			return 1;
		return pascalTriangleElement2(r-1, c) + pascalTriangleElement2(r-1, c-1);
	}
	
	/*
	 * Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
	 */
	public static List<Integer> pascalTriangleRow(int r) {
		List<Integer> row = new ArrayList<>();
		row.add(1);
		int temp = 1;
		int n = r-1;
		
		for(int i=1; i<r; i++) {
			temp = (temp*n)/i;
			row.add(temp);
			n--;
		}
		
		return row;
	}
	
	/*
	 * Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
	 */
	public static List<List<Integer>> pascalTriangleComplete(int n) {
		List<List<Integer>> triangle = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			List<Integer> row = pascalTriangleRow(i);
			triangle.add(row);
		}
		return triangle;
	}

	public static void main(String[] args) {
		System.out.println("Element in th pascal traingle at row 5 and col 3: " + 
							pascalTriangleElement1(5, 3));
		System.out.println("Element in th pascal traingle at row 5 and col 3: " + 
							pascalTriangleElement2(5, 3));
		System.out.println("5th row of pascal triangle: " +
							pascalTriangleRow(5));
		System.out.println("Complete pascal triangle with 5 rows: "+ pascalTriangleComplete(5));
	}

}
