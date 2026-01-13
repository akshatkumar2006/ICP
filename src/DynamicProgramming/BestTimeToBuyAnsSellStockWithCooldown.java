package DynamicProgramming;

public class BestTimeToBuyAnsSellStockWithCooldown {
	
	class Solution {
	    Integer[][] dp;
	    public int maxProfit(int[] prices) {
	        int n = prices.length;

	        dp = new Integer[n][2];

	        return helper(prices, 0, 1);
	    }

	    public int helper(int[] prices, int i, int isBuy){
	        if(i >= prices.length){
	            return 0;
	        }

	        if(dp[i][isBuy] != null) return dp[i][isBuy];

	        int ans = 0;
	        if(isBuy == 1){
	            int buy = -prices[i] + helper(prices, i + 1, 0);
	            int skip = helper(prices, i + 1, 1);
	            ans = Math.max(ans, Math.max(buy, skip));
	        }else{
	            int sell = prices[i] + helper(prices, i + 2, 1);
	            int hold = helper(prices, i + 1, 0);
	            ans = Math.max(ans, Math.max(sell, hold));
	        }

	        return dp[i][isBuy] = ans;
	    }
	}
}
