package Practice_Day3;

public class Convert1DTo2D {
	class Solution {
	    public int[][] construct2DArray(int[] original, int m, int n) {
	        if(m*n < original.length || m*n > original.length){
	            return new int[][]{};
	        }
	        return oneDToTwoD(original, m, n);
	    }
	    
		public static int[][] oneDToTwoD(int[] arr, int m, int n){
			int[][] res = new int[m][n];
			
			int k = 0;
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					res[i][j] = arr[k++];
				}
			}
			
			return res;
		}
	}
}
