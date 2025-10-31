package Practice_Day8;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {
	
	public static void main(String[] args) {
		MinimumCostToMakeArrayEqual m = new MinimumCostToMakeArrayEqual();
		
		Solution solver = m.new Solution();
		
		System.out.println(solver.minCost(new int[]{1,3,5,2}, new int[]{2, 3, 1, 14}));
	}
	
	class Solution {
	    public long minCost(int[] nums, int[] cost) {
	        int n = nums.length;
	        return minimum(nums, cost, n);
	    }

		private long minimum(int[] nums, int[] cost, int n) {
			// TODO Auto-generated method stub
			long l = Arrays.stream(nums).min().getAsInt();
			long h = Arrays.stream(nums).max().getAsInt();
			
//			System.out.println(l + " " + h);
			
			long res = find(nums, cost, l);
			
//			System.out.println(res);
			
			while(l < h) {
				long mid = l + (h - l)/2;
				
				long u = find(nums, cost, mid);
				long v = find(nums, cost, mid + 1);
				
				res = Math.min(res, Math.min(u, v));
				
				if(u < v) {
					h = mid;
				}else {
					l = mid + 1;
				}
			}
			
			return res;
		}

		private long find(int[] nums, int[] cost, long x) {
			// TODO Auto-generated method stub
			int n = nums.length;
			long c = 0;
			for(int i = 0; i < n; i++) {
				c += Math.abs(nums[i] - x)*cost[i];
			}
			return c;
		}

	}
}
