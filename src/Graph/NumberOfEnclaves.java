package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0,}};
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m - 1){
                    if(grid[i][j] == 1){
                        q.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
        }

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for(int d = 0; d < 4; d++){
                int nr = cr + row[d];
                int nc = cc + col[d];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
}
