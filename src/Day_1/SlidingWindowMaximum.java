package Day_1;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMaximum m = new SlidingWindowMaximum();
		Solution solver = m.new Solution();
		
		int k = 3;
		int[] arr = {1,3,-1,-3,5,3,6,7};
		
		int[] ans = solver.maxSlidingWindow(arr, k);
		
		for(int e : ans) {
			System.out.println(e + " ");
		}
	}
	
	class Solution {
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        int arr[] = new int[n - k + 1];
	        int j = 0;

	        for (int i = 0; i < k; i++) {
	            pq.add(new Pair(i, nums[i]));
	        }

	        arr[j++] = pq.peek().val;

	        for (int i = k; i < n; i++) {
	            pq.add(new Pair(i, nums[i]));
	            while (!pq.isEmpty() && i - k >= pq.peek().id) {
	                pq.remove();
	            }
	            arr[j++] = pq.peek().val;
	        }

	        return arr;
	    }

	    static class Pair implements Comparable<Pair> {
	        int val;
	        int id;

	        Pair(int id, int val) {
	            this.id = id;
	            this.val = val;
	        }

	        @Override
	        public int compareTo(Pair p2) {
	            return p2.val - this.val;
	        }
	    }
	}

}
