package Day_4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringsWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringsWithoutRepeatingCharacters m = new LongestSubstringsWithoutRepeatingCharacters();
		Solution solver = m.new Solution();
		
		String s = "tmmzuxt";
		int ans = solver.lengthOfLongestSubstring(s);
		System.out.println(ans);
	}
	
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length();

	        Map<Character, Integer> map = new HashMap<>();
	        int l = 0, r = 0, ans = 0;

	        while(r<n){
	            char ch = s.charAt(r);
	            map.put(ch, map.getOrDefault(ch, 0) + 1);

	            while(map.get(ch)>1) {
	            	char chL = s.charAt(l);
	            	
	            	map.put(chL, map.get(chL) - 1);
	            	
	            	l++;
	            }
	            
	            ans = Math.max(ans, r - l + 1);
//	            System.out.println(ans + "-" + l  + " "+ r);
	            r++;
	        }
	        
	        return ans;
	    }
	}

}
