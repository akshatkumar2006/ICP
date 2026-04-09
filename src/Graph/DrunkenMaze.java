package Graph;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DrunkenMaze {
    // Up, Right, Down, Left
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};

    static class State {
        int r, c, dir, count, dist;
        State(int r, int c, int dir, int count, int dist) {
            this.r = r; this.c = c;
            this.dir = dir;
            this.count = count;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int R = sc.nextInt(); // n in problem (height)
        int C = sc.nextInt(); // m in problem (width)

        int startR = -1, startC = -1;
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }

        // vis[row][col][direction][steps_in_that_direction]
        // steps can be 1, 2, or 3
        boolean[][][][] vis = new boolean[R][C][4][4];
        Queue<State> q = new LinkedList<>();

        // Initialize BFS from 'S' in all 4 possible directions
        for (int d = 0; d < 4; d++) {
            int nr = startR + row[d];
            int nc = startC + col[d];
            if (isValid(nr, nc, R, C, grid)) {
                vis[nr][nc][d][1] = true;
                q.add(new State(nr, nc, d, 1, 1));
            }
        }

        while (!q.isEmpty()) {
            State curr = q.poll();

            if (grid[curr.r][curr.c] == 'T') {
                System.out.println(curr.dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + row[d];
                int nc = curr.c + col[d];

                // If same direction, increment count. If different, reset to 1.
                int nextCount = (d == curr.dir) ? curr.count + 1 : 1;

                // Check constraints: max 3 steps and valid cell
                if (nextCount <= 3 && isValid(nr, nc, R, C, grid)) {
                    if (!vis[nr][nc][d][nextCount]) {
                        vis[nr][nc][d][nextCount] = true;
                        q.add(new State(nr, nc, d, nextCount, curr.dist + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean isValid(int r, int c, int R, int C, char[][] grid) {
        return r >= 0 && r < R && c >= 0 && c < C && grid[r][c] != '#';
    }

    // DFS cannot be used to solve shortest path problems
    private static int solve(char[][] grid, int m, int n, int cr, int cc, int dir, int steps) {
        if(cr < 0 || cr >= m || cc < 0 || cc >= n || grid[cr][cc] == '#' || steps > 3){
            return Integer.MAX_VALUE;
        }

        if(grid[cr][cc] == 'T') return 0;

        grid[cr][cc] = '#';

        int res = Integer.MAX_VALUE;
        for(int d = 0; d < 4; d++){
            int nr = cr + row[d];
            int nc = cc + col[d];
            int nextsteps = d == dir ? steps + 1 : 1;
            int subPro = solve(grid, m, n, nr, nc, d, nextsteps);
            if(subPro != Integer.MAX_VALUE) res = Math.min(res, 1 + subPro);
        }

//        grid[cr][cc] = '.';

        return res;
    }
}
