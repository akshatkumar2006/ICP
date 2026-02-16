package Week_6;

public class CycleLengthQueriesInATree {
	
	class Solution {
	    public int[] cycleLengthQueries(int n, int[][] queries) {
	        int[] ans = new int[queries.length];
	        int i = 0;
	        for(int[] q : queries){
	            int a = q[0], b = q[1];
	            int cnt = 0;
	            while(a != b){
	                if(a > b){
	                    a /= 2;
	                }else{
	                    b /= 2;
	                }
	                cnt++;
	            }

	            ans[i++] = cnt + 1;
	        }

	        return ans;
	    }
	}
}
