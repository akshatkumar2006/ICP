package Week_10;

class MaxConsecutiveOnes_III {
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        System.out.println(solver.longestOnes(arr, k));
    }

    static class Solution {
        public int longestOnes(int[] nums, int k) {
            return perfectness(nums, k);
        }
        public static int perfectness(int[] nums, int k) {
            int ans = 0, l = 0, r = 0, flip = 0;
            while(r<nums.length) {
                // grow
                if(nums[r] == 0) {
                    flip++;
                }
                // shrink
                while(flip>k && l<=r) {
                    if(nums[l] == 0) {
                        flip--;
                    }
                    l++;
                }
                // ans update
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            return ans;
        }
    }
}
