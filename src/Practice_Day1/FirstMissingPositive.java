package Practice_Day1;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	class Solution {
		public int firstMissingPositive(int[] nums) {
			int n = nums.length;

			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < n; i++) {
				if (nums[i] > 0) {
					set.add(nums[i]);
				}
			}

			for (int i = 1; i <= n; i++) {
				if (!set.contains(i)) {
					return i;
				}
			}

			return n + 1;
		}
	}
}
