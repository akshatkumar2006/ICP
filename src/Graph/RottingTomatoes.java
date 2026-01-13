package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingTomatoes {

	class Solution {
	    int[] row = { -1, 0, 1, 0 };
	    int[] col = { 0, 1, 0, -1 };

	    public int orangesRotting(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;

	        Queue<int[]> q = new LinkedList<>();

	        int totalFresh = 0;
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (grid[i][j] == 2)
	                    q.offer(new int[] { i, j });
	                else if (grid[i][j] == 1)
	                    totalFresh++;
	            }
	        }

	        int time = 0;

	        while (!q.isEmpty() && totalFresh > 0) {
	            int size = q.size();

	            for (int i = 0; i < size; i++) {
	                int[] cell = q.poll();

	                for (int d = 0; d < 4; d++) {
	                    int nr = cell[0] + row[d];
	                    int nc = cell[1] + col[d];

	                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
	                        grid[nr][nc] = 2;
	                        q.offer(new int[] { nr, nc });
	                        totalFresh--;
	                    }
	                }
	            }

	            time++;
	        }

	        return totalFresh == 0 ? Math.max(time, 0) : -1;
	    }
	}
}
