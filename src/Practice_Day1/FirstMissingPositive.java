package Practice_Day1;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class FirstMissingPositive {

	class Solution {
		public int firstMissingPositive(int[] nums) {
			int n = nums.length;
			
			// Values which are less than or equal to 0 or greater n i.e. n + 1
			// make them equal to n + 1 because worst case answer will be n + 1
			for (int i = 0; i < n; i++) {
				if(nums[i] <= 0 || nums[i] > n) {
					nums[i] = n + 1;
				}
			}
			
			// har value ki index bnao aur un index ke element ko negative bna do
			// to get odd one out element
			for(int i = 0; i < n; i++) {
				int val = Math.abs(nums[i]);
				if(val > 0 && val <= n) {
					int idx = val - 1;
					nums[idx] = -Math.abs(nums[idx]);
				}
			}
			
			// jo index ke element negative h that means wo index + 1 is present in the array
			// jo index ke element positive h that means wo index + 1 is not present in the array
			for(int i = 0; i < n; i++) {
				if(nums[i] > 0) {
					return i + 1;
				}
			}
			
			return n + 1;
		}

//		public int firstMissingPositive(int[] nums) {
//			int n = nums.length;
//			
//			Set<Integer> set = new HashSet<>();
//			
//			for (int i = 0; i < n; i++) {
//				if (nums[i] > 0) {
//					set.add(nums[i]);
//				}
//			}
//			
//			for (int i = 1; i <= n; i++) {
//				if (!set.contains(i)) {
//					return i;
//				}
//			}
//			
//			return n + 1;
//		}
	}
}
