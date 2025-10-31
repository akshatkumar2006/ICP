package Day_10;

public class RemoveAllAdjacentDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public String removeDuplicates(String s, int k) {
	        int i = 0, n = s.length(), count[] = new int[n];
	        char[] stack = s.toCharArray();
	        for (int j = 0; j < n; ++j, ++i) {
	            stack[i] = stack[j];
	            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
	            if (count[i] == k) i -= k;
	        }
	        return new String(stack, 0, i);
	    }

	    // public String removeDuplicates(String s, int k) {
	    //     // Each stack entry holds: character and its current consecutive count
	    //     Deque<Pair> stack = new ArrayDeque<>();

	    //     for (char c : s.toCharArray()) {
	    //         if (!stack.isEmpty() && stack.peekLast().ch == c) {
	    //             stack.peekLast().cnt++;
	    //             // When we reach k duplicates, remove them
	    //             if (stack.peekLast().cnt == k) {
	    //                 stack.pollLast();
	    //             }
	    //         } else {
	    //             stack.addLast(new Pair(c, 1));
	    //         }
	    //     }

	    //     // Rebuild the final string
	    //     StringBuilder sb = new StringBuilder();
	    //     for (Pair p : stack) {
	    //         for (int i = 0; i < p.cnt; i++) sb.append(p.ch);
	    //     }
	    //     return sb.toString();
	    // }

	    // private static class Pair {
	    //     char ch;
	    //     int cnt;
	    //     Pair(char ch, int cnt) { this.ch = ch; this.cnt = cnt; }
	    // }
	}
}
