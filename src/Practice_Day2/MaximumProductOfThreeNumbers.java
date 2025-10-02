package Practice_Day2;

public class MaximumProductOfThreeNumbers {
	class Solution {
	    public int maximumProduct(int[] nums) {
	        if (nums.length == 3) {
	            return nums[0] * nums[1] * nums[2];
	        }
	        int max1 = Integer.MIN_VALUE;
	        int max2 = Integer.MIN_VALUE;
	        int max3 = Integer.MIN_VALUE;
	        int min1 = Integer.MAX_VALUE;
	        int min2 = Integer.MAX_VALUE;
	        for (int num : nums) {
	            if (num >= max3) {
	                if (num >= max1) {
	                    max3 = max2;
	                    max2 = max1;
	                    max1 = num;
	                } else if (num >= max2) {
	                    max3 = max2;
	                    max2 = num;
	                } else if (num >= max3) {
	                    max3 = num;
	                }
	            }
	            if ((num < min2)) {
	                
	                if (num <= min1) {
	                    min2 = min1;
	                    min1 = num;
	                } else if (num <= min2) {
	                    min2 = num;
	                }
	            }
	        }

	        int sum1 = max1 * max2 * max3;
	        int sum2 = min1 * min2 * max1;

	        return sum1 > sum2 ? sum1 : sum2;
	    }
	}
}
