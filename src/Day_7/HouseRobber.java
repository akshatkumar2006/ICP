package Day_7;

public class HouseRobber {
	class Solution {
	    public int rob(int[] nums) {
	        int n = nums.length;

	        // int[] dp = new int[n];

	        // Arrays.fill(dp, -1);

	        // return robber(nums, 0, dp);
	        return robber(nums, n);
	    }

	    // iterative dp
	    public int robber(int[] arr, int n){
	        if(n == 1) return arr[0];

	        int[] dp = new int[n];

	        dp[0] = arr[0];
	        dp[1] = Math.max(arr[1], arr[0]);

	        for(int i = 2; i < n; i++){
	            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
	        }

	        return dp[n - 1];
	    }

	    // recursive dp
	    // public int robber(int[] nums, int idx, int[] dp){
	    //     if(idx >= nums.length){
	    //         return 0;
	    //     }

	    //     if(dp[idx] != -1){
	    //         return dp[idx];
	    //     }

	    //     int rob = nums[idx] + robber(nums, idx + 2, dp);
	    //     int not_rob = robber(nums, idx + 1, dp);

	    //     return dp[idx] = Math.max(rob, not_rob);
	    // }
	}
}
