package Day_6;

public class WordSearch {
	class Solution {
	    public boolean exist(char[][] maze, String word) {
	        for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					if (maze[i][j] == word.charAt(0)) {
						boolean ans = Word_Search2(maze, i, j, word, 0);
						if (ans) {
							System.out.println(ans);
							return ans;
						}
					}

				}

			}
			return false;
		}

		public static boolean Word_Search2(char[][] maze, int cr, int cc, String word, int idx) {
			if (idx == word.length()) {
				return true;
			}

			if (cr < 0 || cc < 0 || cr >= maze.length || cc >= maze[0].length || maze[cr][cc] != word.charAt(idx)) {
				return false;
			}
			int[] r = { -1, 1, 0, 0 };
			int[] c = { 0, 0, -1, 1 };
			maze[cr][cc] = '*';
			boolean ans = false;

			for (int i = 0; i < c.length; i++) {
				ans = Word_Search2(maze, cr + r[i], cc + c[i], word, idx + 1);
				if (ans) {
					return ans;
				}
			}

			maze[cr][cc] = word.charAt(idx);
			return false;

		}
	}
}
