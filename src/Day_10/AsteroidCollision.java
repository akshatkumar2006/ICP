package Day_10;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int[] asteroidCollision(int[] asteroids) {
	        int n = asteroids.length;

	        Stack<Integer> st = new Stack<>();

	        for(int i = 0; i<n; i++){
	            int ele = asteroids[i];
	            if(ele>0){
	                st.push(ele);
	            }else{
	                while(!st.isEmpty() && (st.peek()>0 && st.peek()<-1*ele)){
	                    st.pop();
	                }
	                if(st.isEmpty() || st.peek()<0){
	                    st.push(ele);
	                }else if(st.peek() == -1*ele){
	                    st.pop();
	                }
	            }
	        }
	        
	        return st.stream().mapToInt(Integer::intValue).toArray();
	    }
	}
}
