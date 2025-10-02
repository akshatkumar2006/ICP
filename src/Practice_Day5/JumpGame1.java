package Practice_Day5;

public class JumpGame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame1 m = new JumpGame1();
		Solution solver = m.new Solution();
		
		int[] nums = {3,2,1,0,4};
		System.out.println(solver.canJump(nums));
	}
	
	class Solution {
	    public boolean canJump(int[] nums) {
	        // int maxJump = 0;
	        // for(int i : nums){
	        //     if(maxJump < 0){
	        //         return false;
	        //     }else if(maxJump<i){
	        //         maxJump = i;
	        //     }
	        //     maxJump--;
	        // }
	        // return true;

	        int reachable = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (i > reachable)
	                return false;
	            reachable = Math.max(reachable, i + nums[i]);
	        }
	        return true;
	    }
	}
}
