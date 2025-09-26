package DailyQuestions_ICP;

import java.util.Arrays;

public class MinimumArrowsToBurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumArrowsToBurstBalloons m = new MinimumArrowsToBurstBalloons();
		Solution solver = m.new Solution();

		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		int ans = solver.findMinArrowShots(points);

		System.out.println(ans);
	}
	
	class Solution {
	    public int findMinArrowShots(int[][] points) {
	        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));

	        int prev = points[0][1];
	        int count=1;
	        for(int i=1;i<points.length;i++){
	            if(points[i][0]<=prev){
	                continue;
	            }
	            else{
	                count++;
	                prev = points[i][1];
	            }
	        }
	        return count;
	    }
	}
}
