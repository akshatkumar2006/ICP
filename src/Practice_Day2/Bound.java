package Practice_Day2;

public class Bound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bound m = new Bound();
		Solution solver = m.new Solution();
		
		int[] nums = {1, 2, 4, 4, 4, 7, 9};
		for(int i = 0; i <= 10; i++) {
//			System.out.print(solver.lowerBound(nums, i) + " ");
			System.out.print(solver.upperBound(nums, i) + " ");
		}
	}

	class Solution {
		public int lowerBound(int[] nums, int target) {
			int n = nums.length;
			int l = 0, h = n - 1;
			
			boolean isFound = false;
			int idx = -1;
			
			while(l<=h) {
				int mid = (l + h)/2;

				if(nums[mid] >= target) {
					isFound = true;
					idx = mid;
					h = mid - 1;
				}else {
					l = mid + 1;
				}
			}
			
			if(isFound) {
				return idx;
			}
			return l;
		}
		
		public int upperBound(int[] nums, int target) {
			int n = nums.length;
			int l = 0, h = n - 1;
			
//			boolean isFound = false;
//			int idx = -1;
			
			while(l<=h) {
				int mid = (l + h)/2;

				if(nums[mid] <= target) {
//					isFound = true;
//					idx = mid;
					l = mid + 1;
				}else {
					h = mid-1;
				}
			}
			
//			if(isFound) {
//				return idx;
//			}
			return l;
		}

	}

}
