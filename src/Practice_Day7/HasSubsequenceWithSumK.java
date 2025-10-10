package Practice_Day7;

public class HasSubsequenceWithSumK {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		HasSubsequenceWithSumK m = new HasSubsequenceWithSumK();
		Solution solver = m.new Solution();
		System.out.println(solver.checkSubsequenceSum(7, new int[] {10,1,2,7,6,1,5}, 8));
		System.out.println(solver.checkSubsequenceSum(5, new int[] {2,3,5,7,9}, 100));
	}

	// User function Template for Java

	class Solution {
		public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
			// code here
	        Boolean[][] dp = new Boolean[N][K + 1];
	        return solve(0, K, arr, dp);
	    }
	    
	    public static boolean solve(int i, int target, int[] arr, Boolean[][] dp) {
	        if (target == 0) return true;
	        if (i == arr.length) return false;
	        if (dp[i][target] != null) return dp[i][target];
	        
	        // Don't take current element
	        boolean res = solve(i + 1, target, arr, dp);
	        
	        // Take current element if possible
	        if (arr[i] <= target) {
	            res = res || solve(i + 1, target - arr[i], arr, dp);
	        }
	        
	        dp[i][target] = res;
	        return res;
	    }
	}
}
