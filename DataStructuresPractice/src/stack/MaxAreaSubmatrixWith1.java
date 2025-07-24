package stack;

public class MaxAreaSubmatrixWith1 {
	
	public static int maxArea(int[][] a) {
		int[] curRow = a[0];
		int maxArea = MaxAreaRectangleInHistogram.maxAreaOfRectangle2(curRow);
		
		for(int i=1; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j] == 1)
					curRow[j] += 1;
				else
					curRow[j] = 0;
			}
			int area = MaxAreaRectangleInHistogram.maxAreaOfRectangle2(curRow);
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] a = {{1,1,0,1,1},{1,1,1,1,1},{0,1,1,1,1},{1,1,1,1,1},{1,0,1,1,1},{1,1,1,1,1}};
		System.out.println("Max area of submatrix: "+ maxArea(a));
	}

}
