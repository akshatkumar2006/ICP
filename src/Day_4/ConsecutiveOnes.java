package Day_4;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConsecutiveOnes {
	 class Solution {
	        public int longestOnes(int[] nums, int k) {
	            Deque<Integer> dq = new ArrayDeque<>();
	            int zeros = 0;
	            int maxLen = 0;

	            for (int i = 0; i < nums.length; i++) {
	                dq.addLast(nums[i]);
	                if (nums[i] == 0) zeros++;
	                while (zeros > k) {
	                    int removed = dq.removeFirst();
	                    if (removed == 0) zeros--;
	                }
	                maxLen = Math.max(maxLen, dq.size());
	            }

	            return maxLen;
	        }
	    }
}
