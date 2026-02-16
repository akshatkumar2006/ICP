package Week_3;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTheWinnerOfTheCircularGame m = new FindTheWinnerOfTheCircularGame();

		Solution solver = m.new Solution();
		System.out.println(solver.findTheWinner(5, 2));
	}

	class Solution {
		public int findTheWinner(int n, int k) {
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				q.offer(i);
			}
			int c = 0;
			while (q.size() != 1) {
				c++;
				int v = q.poll();
				if (c == k) {
					c = 0;
					continue;
				}
				q.offer(v);
			}
			return q.poll();
		}
	}
}
