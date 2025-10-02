package Practice_Day5;

public class JumpGame2 {
	class Solution {
		public int jump(int[] nums) {
			int reachable = 0;
			int count = 0;
			int endJump = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				reachable = Math.max(reachable, i + nums[i]);
				if(i==endJump) {
					count++;
					endJump = reachable;
				}
			}
			return count;
		}
	}
}
