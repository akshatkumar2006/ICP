package Practice_Day3;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInAMatrix {
	public static void main(String[] args) {
		int[][] matrix = { 
				{ 3, 7, 8 }, 
				{ 9, 11, 13 }, 
				{ 15, 16, 17 } };
		LuckyNumberInAMatrix m = new LuckyNumberInAMatrix();
		Solution solver = m.new Solution();
		List<Integer> ll = solver.luckyNumbers(matrix);

		for (int ele : ll) {
			System.out.println(ele + " ");
		}
	}

	class Solution {
		public List<Integer> luckyNumbers(int[][] matrix) {
			int m = matrix.length;
			int n = matrix[0].length;
			
			List<Integer> ll = new ArrayList<Integer>();

			int[] row = new int[m];
	        int[] col = new int[n];
	        
	        for(int i = 0; i < m; i++) { 
	        	int minn = matrix[i][0];
	        	for(int j = 1; j < n; j++) {
	        		if(matrix[i][j] < minn) {
	        			minn = matrix[i][j];
	        		}
	        	}
	        	row[i] = minn;
	        }
	        
	        for(int j = 0; j < n; j++) { 
	        	int maxx = matrix[0][j];
	        	for(int i = 1; i < m; i++) {
	        		if(matrix[i][j] > maxx) {
	        			maxx = matrix[i][j];
	        		}
	        	}
	        	col[j] = maxx;
	        }
	        
	        for(int i = 0; i < m; i++) {
	        	for(int j = 0; j < n; j++) {
	        		if(matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
	        			ll.add(row[i]);
	        		}
	        	}
	        }
	        
//	        for(int i = 0; i < m; i++) {
//	        	System.out.println(row[i] + " ");
//	        }
//	        
//	        for(int j = 0; j < n; j++) {
//	        	System.out.println(col[j] + " ");
//	        }
	        
	        return ll;
		}
	}
}
