package DynamicProgramming;

import java.util.Scanner;

public class PaintingFences {

	public static void main(String[] args) {
		PaintingFences m = new PaintingFences();

		Solution solver = m.new Solution();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		sc.close();
		System.out.println(solver.countWays(n, k));
	}

	class Solution {
		int countWays(int n, int k) {
			int same = 0;
			int diff = k;
			int total = k;

			for (int i = 2; i <= n; i++) {
				same = diff;
				diff = total * (k - 1);
				total = same + diff;
			}

			return total;
		}
	}
}
