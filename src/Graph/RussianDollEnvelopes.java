package Graph;

import java.util.Arrays;

public class RussianDollEnvelopes {

	class Solution {
		public int maxEnvelopes(int[][] envelopes) {
			return lis(envelopes, envelopes.length);
		}

		public int lis(int[][] arr, int n) {
			// TODO Auto-generated method stubr
			if (n == 0)
				return 0;

			Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

			int[] dp = new int[n];
			int len = 1;
			dp[0] = arr[0][1]; // storing ending element of each length subsequence
			for (int[] env : arr) {
				int h = env[1];
				int idx = Arrays.binarySearch(dp, 0, len, h);
				if (idx < 0)
					idx = -(idx + 1);
				dp[idx] = h;
				if (idx == len)
					len++;
			}
			return len;
		}
	}
}
