package Practice_Day3;

import java.util.Stack;

public class HelpClassmates {
	class Solution {
	    public static int[] help_classmate(int arr[], int n) {
	        // Your code goes here
	        int[] nextSmaller = new int[n];
	        
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = 0; i < n; i++){
	            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
	                nextSmaller[st.pop()] = arr[i];
	            }
	            st.push(i);
	        }
	        
	        while(!st.isEmpty()){
	            nextSmaller[st.pop()] = -1;
	        }
	        
	        return nextSmaller;
	    }
	}

}
