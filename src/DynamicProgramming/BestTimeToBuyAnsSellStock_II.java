package DynamicProgramming;

public class BestTimeToBuyAnsSellStock_II {
	
	class Solution {
	    public int maxProfit(int[] prices) {
	        int profit = 0;
	        for (int i=1;i<prices.length;i++){
	            if (prices[i]>prices[i-1]){
	                profit += prices[i]-prices[i-1];
	            }
	        }
	        return profit;
	    }

//	     Integer[][] dp;
//	     public int maxProfit(int[] prices) {
//	         int n = prices.length;
//	         dp = new Integer[n][2];
//	         return helper(prices, 0, 1);
//	     }
//
//	     public int helper(int[] prices, int i, int isBuy){
//	         if(i >= prices.length) return 0;
//
//	         if(dp[i][isBuy] != null) return dp[i][isBuy];
//
//	         int ans = 0;
//	         if(isBuy == 1){
//	             int buy = -prices[i] + helper(prices, i + 1, 0);
//	             int skip = helper(prices, i + 1, 1);
//	             ans = Math.max(ans, Math.max(buy, skip));
//	         }else{
//	             int sell = prices[i] + helper(prices, i + 1, 1);
//	             int hold = helper(prices, i + 1, 0);
//	             ans = Math.max(ans, Math.max(sell, hold));
//	         }
//
//	         return dp[i][isBuy] = ans;
//	     }
	}
}
