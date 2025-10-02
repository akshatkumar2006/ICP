package Day_4;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
	class Solution {
		public boolean checkInclusion(String s1, String s2) {
			int n = s1.length();
			int m = s2.length();

			if (n > m) {
				return false;
			}

			Map<Character, Integer> s1Count = new HashMap<>();
			Map<Character, Integer> s2Count = new HashMap<>();

			for (int i = 0; i < n; i++) {
				s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0) + 1);
				s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0) + 1);
			}

			if (s1Count.equals(s2Count))
				return true;

			int l = 0, r = n;
			while (r < m) {
				char charRight = s2.charAt(r);
				s2Count.put(charRight, s2Count.getOrDefault(charRight, 0) + 1);

				char charLeft = s2.charAt(l);
				s2Count.put(charLeft, s2Count.get(charLeft) - 1);
				if (s2Count.get(charLeft) == 0) {
					s2Count.remove(charLeft);
				}

				l++;

				if (s1Count.equals(s2Count)) {
					return true;
				}

				r++;
			}

			return false;
		}
	}
}
