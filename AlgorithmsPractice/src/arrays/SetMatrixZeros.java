package arrays;

import java.util.Arrays;

public class SetMatrixZeros {
	
	/*
	 * Brute force approach
	 * https://takeuforward.org/data-structure/set-matrix-zero/
	 */
	public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    int x = 0;
                    int y = 0;
                    
                    while(x < m){
                        if(matrix[x][j] != 0)
                            matrix[x][j] = -1;
                        x++;
                    }

                    while(y < n){
                        if(matrix[i][y] != 0)
                            matrix[i][y] = -1;
                        y++;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }
	
	/*
	 * Better approach
	 * https://takeuforward.org/data-structure/set-matrix-zero/
	 */
	public static void setZeroes2(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;
        
        int[] col = new int[m];
        int[] row = new int[n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            	if(matrix[i][j] == 0) {
            		col[i] = 1;
            		row[j] = 1;
            	}
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            	if(col[i] == 1 || row[j] ==1) {
            		matrix[i][j] = 0;
            	}
            }
        }
	}
	
	/*
	 * Optimal Approach
	 * https://takeuforward.org/data-structure/set-matrix-zero/
	 */
	public static void setZeroes3(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(matrix[i][j] == 0) {
        			if(i == 0) {
        				col0 = 0;
        			}
        			else if(j == 0) {
        				matrix[0][0] = 0;
        			}
        			else {
        				matrix[0][j] = 0;
            			matrix[i][0] = 0;
        			}
        		}
        	}
        }
        
        for(int i=1 ;i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if(matrix[i][0]==0 || matrix[0][j]==0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if(matrix[0][0] == 0) {
        	for(int i=0; i<m; i++) {
        		matrix[i][0] = 0;
        	}
        }
        
        if(col0 == 0) {
        	for(int j=0; j<n; j++) {
        		matrix[0][j] = 0;
        	}
        }
        
	}
	
	public static void printMatrix(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            	System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,1,0,1},{1,1,1,1},{1,1,1,1}};
		System.out.println("Input matrix => ");
		printMatrix(matrix);
		
//		setZeroes1(matrix);
//		setZeroes2(matrix);
		setZeroes3(matrix);
		
		System.out.println("Output matrix => ");
		printMatrix(matrix);
	}

}
