package Week_2;

public class MinimumOperationToMakeAllElementsEqualToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumOperationToMakeAllElementsEqualToOne m = new MinimumOperationToMakeAllElementsEqualToOne();
		Solution solver = m.new Solution();
		System.out.println(solver.minOperations(new int[] { 0, 1, 1, 1, 0, 0 }));
	}

	class Solution {
		public int minOperations(int[] nums) {
			int n = nums.length, k = 0;

			for (int i = 0; i <= n - 3; i++) {
				if (nums[i] == 0) {
					nums[i] ^= 1;
					nums[i + 1] ^= 1;
					nums[i + 2] ^= 1;
					k++;
				}
			}

			for (int num : nums) {
				if (num == 0)
					return -1;
			}
			return k;
		}
	}
}
