package Day_7;

public class MaximumSubarraySum_DP {
	public class Solution {
	    public int maxSubArray(int[] nums) {
	        int n = nums.length;
	        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
	        dp[0] = nums[0];
	        int max = dp[0];

	        for (int i = 1; i < n; i++) {
	            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	            max = Math.max(max, dp[i]);
	        }

	        return max;
	    }
	    // public int maxSubArray(int[] nums) {
	    //     int n = nums.length;
	    //     int[][] dp = new int[2][n];
	    //     for (int j = 0; j < n; j++) {
	    //         dp[0][j] = -1;
	    //         dp[1][j] = -1;
	    //     }
	    //     return solve(nums, 0, false, dp);
	    // }

	    // private int solve(int[] A, int i, boolean mustPick, int[][] dp) {
	    //     if (i >= A.length) return mustPick ? 0 : -100000;
	    //     int idx = mustPick ? 1 : 0;
	    //     if (dp[idx][i] != -1) return dp[idx][i];
	    //     int res;
	    //     if (mustPick) {
	    //         res = Math.max(0, A[i] + solve(A, i + 1, true, dp));
	    //     } else {
	    //         res = Math.max(solve(A, i + 1, false, dp), A[i] + solve(A, i + 1, true, dp));
	    //     }
	    //     dp[idx][i] = res;
	    //     return res;
	    // }
	}

}
