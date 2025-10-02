package Day_5;

import java.util.Arrays;

public class NonOverlappingIntervals {
	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {
			int n = intervals.length;

			Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

			int end = intervals[0][1];
			int overlap = 0;

			for (int i = 1; i < n; i++) {
				if (intervals[i][0] < end) {
					overlap++;
				} else {
					end = intervals[i][1];
				}
			}

			return overlap;
		}
	}
}
