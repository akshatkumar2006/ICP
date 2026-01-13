package DynamicProgramming;

public class MaximalSquare {

	class Solution {
	    public int maximalSquare(char[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;

	        int[][] dp = new int[m][n];
	        
	        int maxx = 0;

	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(matrix[i][j] == '1'){
	                    if(i == 0 || j == 0){
	                        dp[i][j] = 1;
	                    }else {
	                        int up = dp[i - 1][j];
	                        int upLeftDia = dp[i - 1][j - 1];
	                        int left = dp[i][j - 1];
	                        
	                        dp[i][j] = Math.min(Math.min(upLeftDia, up), left) + 1;      
	                    }
	                    maxx = Math.max(maxx, dp[i][j]);
	                }
	            }
	        }
	        
	        return maxx*maxx;
	    }
	}
}
