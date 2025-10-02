package Practice_Day1;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
	class Solution {
		public int totalFruit(int[] fruits) {
			int n = fruits.length;

			Map<Integer, Integer> map = new HashMap<>();

			int ans = 0;
			int start = 0;
			for (int end = 0; end < n; end++) {
				map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

				while (map.size() >= 3) {
					map.put(fruits[start], map.get(fruits[start]) - 1);
					if (map.get(fruits[start]) == 0)
						map.remove(fruits[start]);
					start++;
				}

				ans = Math.max(ans, end - start + 1);
			}

			return ans;
		}
	}
}
