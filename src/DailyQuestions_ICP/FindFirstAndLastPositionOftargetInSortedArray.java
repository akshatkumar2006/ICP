package DailyQuestions_ICP;

public class FindFirstAndLastPositionOftargetInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstAndLastPositionOftargetInSortedArray m = new FindFirstAndLastPositionOftargetInSortedArray();
		Solution solver = m.new Solution();
		
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		
		int[] res = solver.searchRange(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}

	class Solution {
	    public int[] searchRange(int[] nums, int target) {
	        int[] result = {-1, -1};
	        int left = binarySearch(nums, target, true);
	        int right = binarySearch(nums, target, false);
	        result[0] = left;
	        result[1] = right;
	        return result;        
	    }

	    private int binarySearch(int[] nums, int target, boolean isGoingLeft) {
	        int left = 0;
	        int right = nums.length - 1;
	        int idx = -1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            
	            if (nums[mid] > target) {
	                right = mid - 1;
	            } else if (nums[mid] < target) {
	                left = mid + 1;
	            } else {
	                idx = mid;
	                if (isGoingLeft) {
	                    right = mid - 1;
	                } else {
	                    left = mid + 1;
	                }
	            }
	        }

	        return idx;
	    }

	}
}
