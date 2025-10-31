package Practice_Day8;

public class SubsequenceWithSumK {
	
	public static void main(String[] args) {
		System.out.println(SubsequenceWithSumK.Solution.checkSubsequenceSum(7, new int[] {10,1,2,7,6,1,5}, 8));
	}

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
	
//	class Solution {
//		public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
//			// code here
//			int sum = Arrays.stream(arr).sum();
//			int[][] dp = new int[N][K+1];
//			for(int[] a : dp){
//			    Arrays.fill(a, -1);
//			}
//			return subsequenceSumK(N, arr, K, 0, 0, dp);
//		}
//
//		static boolean subsequenceSumK(int n, int[] arr, int k, int i, int sum, int[][] dp) {
//		    if(sum > k){
//		        return false;
//		    }
//			if (sum == k) {
//				return true;
//			}
//
//			if (i == n) {
//				return false;
//			}
//			
//			if(dp[i][sum] != -1){
//			    if(dp[i][sum] == 1){
//			        return true;
//			    }else{
//			        return false;
//			    }
//			}
//
//			boolean inc = subsequenceSumK(n, arr, k, i + 1, sum + arr[i], dp);
//			boolean exc = subsequenceSumK(n, arr, k, i + 1, sum, dp);
//
//	        dp[i][sum] = inc || exc ? 1 : 0;
//			return inc||exc;
//		}
//	}
	
}
