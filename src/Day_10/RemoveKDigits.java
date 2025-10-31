package Day_10;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public String removeKdigits(String num, int k) {
	        Deque<Character> stack = new ArrayDeque<>();
	        for (char digit : num.toCharArray()) {
	           
	            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
	                stack.removeLast();
	                k--;
	            }
	           
	            stack.addLast(digit);
	        }
	        
	        while (k > 0 && !stack.isEmpty()) {
	            stack.removeLast();
	            k--;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        while (!stack.isEmpty()) {
	            sb.append(stack.removeFirst());
	        }
	        
	        int firstNonZeroIndex = 0;
	        while (firstNonZeroIndex < sb.length() - 1 && sb.charAt(firstNonZeroIndex) == '0') {
	            firstNonZeroIndex++;
	        }
	        
	        String result = sb.substring(firstNonZeroIndex);
	        
	        return result.isEmpty() ? "0" : result;
	    }
	}
}
