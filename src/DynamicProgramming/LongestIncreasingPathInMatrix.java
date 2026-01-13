package DynamicProgramming;

public class LongestIncreasingPathInMatrix {

	class Solution {
	    public int longestIncreasingPath(int[][] matrix) {
	        // Brute Force is DFS Call At Every cell in four directions

	        int max = 0;
	        int[][] dp = new int[matrix.length][matrix[0].length];
	        for (int i = 0; i < dp.length; i++) {
	            for (int j = 0; j < dp[0].length; j++) {
	                dp[i][j] = -1;
	            }
	        }
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                max = Math.max(max, LIP(matrix, dp, i, j));
	            }
	        }
	        return max;
	    }

	    private static int LIP(int[][] matrix, int[][] dp, int i, int j) {
	        // TODO Auto-generated method stub
	        if (dp[i][j] != -1) {
	            return dp[i][j];
	        }
	        int ans = 1;
	        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	        for (int[] d : dir) {
	            int ni = i + d[0];
	            int nj = j + d[1];
	            if (ni >= 0 && nj >= 0 && ni < matrix.length && nj < matrix[0].length && matrix[ni][nj] > matrix[i][j]) {
	                ans = Math.max(ans, 1 + LIP(matrix, dp, ni, nj));
	            }
	        }
	        return dp[i][j] = ans;
	    }
	}
	
	
//	class Solution {
//	    static {
//	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//	            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
//	                writer.write("0");
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	        }));
//	    }
//
//	    
//	    private int[] nr={1,0,-1,0};
//	    private int[] nc={0,-1,0,1};
//	    public int longestIncreasingPath(int[][] matrix) {
//	        int m = matrix.length;
//	        int n = matrix[0].length;
//	        int inDegree[][]=new int[m][n];
//	        for(int i=0;i<m;i++){
//	            for(int j=0;j<n;j++){
//	                for(int x = 0;x<4;x++){
//	                    int newRow = nr[x]+i;
//	                    int newCol = nc[x]+j;
//	                    if(newRow>=m||newRow<0||newCol>=n||newCol<0)continue;
//	                    if(matrix[newRow][newCol]>matrix[i][j]){
//	                        //isedge
//	                        inDegree[newRow][newCol]++;
//	                    }
//	                }
//	            }
//	        }
//	        // We convert a 2D cell (row, col) into a single integer using row-major order:
//	        // id = row * cols + col, where cols = matrix[0].length.
//	        // 
//	        // To recover the coordinates back:
//	        // row = id / cols and col = id % cols.
//	        // 
//	        // This avoids creating int[] objects and makes queue operations faster.
//	        ArrayDeque<Integer>queue= new ArrayDeque<>();
//	        for(int i=0;i<m;i++){
//	            for(int j=0;j<n;j++){
//	                if(inDegree[i][j]==0)queue.add(i*n+j);
//	            }
//	        }
//	        int layer = 0;
//	        while(!queue.isEmpty()){
//	            int queueSize = queue.size();
//	            while(0<queueSize--){
//	                int id = queue.poll();
//	                int i = id/n;
//	                int j = id%n;
//	                for(int x = 0;x<4;x++){
//	                    int newRow = nr[x]+i;
//	                    int newCol = nc[x]+j;
//	                    if(newRow>=m||newRow<0||newCol>=n||newCol<0)continue;
//	                    if(matrix[newRow][newCol]>matrix[i][j]){
//	                        inDegree[newRow][newCol]--;
//	                        if(inDegree[newRow][newCol]==0){
//	                            queue.add(newRow*n+newCol);
//	                        }
//	                    }
//	                }
//	            }
//	            layer++;
//	        }
//	        return layer;
//	    }
//
//	}



	// 329. Longest Increasing Path in a Matrix
}
