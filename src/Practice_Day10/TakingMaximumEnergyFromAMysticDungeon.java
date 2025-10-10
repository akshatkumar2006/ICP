package Practice_Day10;

import java.util.Arrays;

@SuppressWarnings("unused")
public class TakingMaximumEnergyFromAMysticDungeon {
	
	public static void main(String[] args) {
		TakingMaximumEnergyFromAMysticDungeon m = new TakingMaximumEnergyFromAMysticDungeon();
		
		Solution solver = m.new Solution();
		
		System.out.println(solver.maximumEnergy(new int[]{5,2,-10,-5,1}, 3));
	}
	
	
	class Solution {
	    public int maximumEnergy(int[] energy, int k) {
	        int n = energy.length, m = n-k, max = -1000;
	        for (int i = m; i < n; i++) {
	            for (int j = i, tmp = 0; j > -1; j -= k) {
	                tmp += energy[j];
	                if (max < tmp) {
	                    max = tmp;
	                }
	            }
	        }
	        
	        return max;
	    }
	}
	
	// DP
//	class Solution {
//	    public int maximumEnergy(int[] energy, int k) {
//	        int n = energy.length;
//	        
//	        int[] dp = new int[n];
//	        
//	        for(int i = n - 1; i >= n - k; i--) {
//	        	dp[i] = energy[i];
//	        }
//	        
//	        for(int i = n - k - 1; i >= 0; i--) {
//	        	dp[i] = energy[i] + dp[i + k];
//	        }
//	        
//	        int maxEnergy = Arrays.stream(dp).max().getAsInt();
//	        
//	        return maxEnergy;
//	    }
//	}
	
	// TLE
//	class Solution {
//		public int maximumEnergy(int[] energy, int k) {
//			int n = energy.length;
//			
//			int maxEnergy = Integer.MIN_VALUE;
//			for(int i = 0; i < n; i++) {
//				int j = i;
//				int currEnergy = 0;
//				while(j < n) {
//					currEnergy+=energy[j];
//					j+=k;
//				}
////	        	System.out.println(currEnergy);
//				maxEnergy = Math.max(maxEnergy, currEnergy);
//			}
//			
//			return maxEnergy;
//		}
//	}
	
//	class Solution {
//		public int maximumEnergy(int[] energy, int k) {
//			int n = energy.length;
//	        int[] dp = new int[n];
//	        int maxEnergy = Integer.MIN_VALUE;
//
//	        for (int i = n - 1; i >= 0; i--) {
//	            if (i + k < n) {
//	                dp[i] = energy[i] + dp[i + k];
//	            } else {
//	                dp[i] = energy[i];
//	            }
//	            maxEnergy = Math.max(maxEnergy, dp[i]);
//	        }
//
//	        return maxEnergy;
//		}
//	}
}
