package Week_2;

import java.util.*;

public class SumOfSubarraysMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfSubarraysMinimum m = new SumOfSubarraysMinimum();

		Solution solver = m.new Solution();

		int[] arr = { 3, 1, 2, 4 };
		System.out.println(solver.sumSubarrayMins(arr));
	}

	class Solution {
		int MOD = 1_000_000_007;
		public int sumSubarrayMins(int[] arr) {
			int n = arr.length;
			
			Stack<Integer> st = new Stack<>();
	        long res = 0;
	        
	        int[] preSmaller = new int[n];
	        int[] nextSmaller = new int[n];

	        for(int i = 0; i < n; i++){
	        	while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
	                st.pop();
	            }
	            preSmaller[i] = st.isEmpty() ? -1 : st.peek();
	            st.push(i);
	        }
	        
	        st.clear();
	        
	        for(int i = n - 1; i >= 0; i--){
	        	while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
	        		st.pop();
	        	}
	        	nextSmaller[i] = st.isEmpty() ? n : st.peek();
	        	st.push(i);
	        }
	        
	        for (int i = 0; i < n; i++) {
	            long left = i - preSmaller[i];
	            long right = nextSmaller[i] - i;
	            res = (res + arr[i] * left % MOD * right % MOD) % MOD;
	        }

	        return (int) res;
		}
	}
}
