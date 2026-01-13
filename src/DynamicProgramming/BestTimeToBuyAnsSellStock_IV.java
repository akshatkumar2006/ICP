package DynamicProgramming;

public class BestTimeToBuyAnsSellStock_IV {
	
	class Solution {
		Integer[][][] dp;
	    public int maxProfit(int k, int[] prices) {
	        int n = prices.length;
	        dp = new Integer[n][2][k];
	        return helper(prices, 0, 1, k);
	    }
	    
	    public int helper(int[] prices, int i, int isBuy, int k) {
			if (i >= prices.length || k == 0)
				return 0;

			if (dp[i][isBuy][k] != null)
				return dp[i][isBuy][k];

			int ans = 0;
			if (isBuy == 1) {
				int buy = -prices[i] + helper(prices, i + 1, 0, k);
				int skip = helper(prices, i + 1, 1, k);
				ans = Math.max(ans, Math.max(buy, skip));
			} else {
				int sell = prices[i] + helper(prices, i + 1, 1, k - 1);
				int hold = helper(prices, i + 1, 0, k);
				ans = Math.max(ans, Math.max(sell, hold));
			}

			return dp[i][isBuy][k] = ans;
		}
	}
}
