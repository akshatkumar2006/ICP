package DynamicProgramming;

public class BestTimeToBuyAnsSellStockWithTransactionFee {
	
	class Solution {
	    Integer[][] dp;
	    public int maxProfit(int[] prices, int fee) {
	        int n = prices.length;
	        dp = new Integer[n][2];
	        return helper(prices, 0, 1, fee);
	    }

	    public int helper(int[] prices, int i, int isBuy, int fee){
	        if(i >= prices.length) return 0;

	        if(dp[i][isBuy] != null) return dp[i][isBuy];

	        int ans = 0;
	        if(isBuy == 1){
	            int buy = -prices[i] + helper(prices, i + 1, 0, fee) - fee;
	            int skip = helper(prices, i + 1, 1, fee);
	            ans = Math.max(ans, Math.max(buy, skip));
	        }else{
	            int sell = prices[i] + helper(prices, i + 1, 1, fee);
	            int hold = helper(prices, i + 1, 0, fee);
	            ans = Math.max(ans, Math.max(sell, hold));
	        }

	        return dp[i][isBuy] = ans;
	    }
	}
}
