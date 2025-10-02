package Day_4;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	class Solution{
		public int characterReplacement(String s, int k) {
		    Map<Character, Integer> mp = new HashMap<>();
		    int start = 0;
		    int maxx = 0;
		    int ans = 0;
		    for (int end = 0; end < s.length(); end++) {
		        char ch = s.charAt(end);
		        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
		        maxx = Math.max(maxx, mp.get(ch));
		        while (start <= end && end - start + 1 - maxx > k) {
		            char left = s.charAt(start);
		            mp.put(left, mp.get(left) - 1);
		            start++;
		        }
		        ans = Math.max(ans, end - start + 1);
		    }
		    return ans;
		}
	}
}
