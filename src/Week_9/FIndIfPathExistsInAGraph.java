package Week_9;

import java.util.*;

public class FIndIfPathExistsInAGraph {
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            return ifPathExists(map, n, source, destination);
        }

        public boolean ifPathExists(HashMap<Integer, ArrayList<Integer>> map, int n, int src, int des) {
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while (!q.isEmpty()) {
                int curr = q.poll();

                if (visited.contains(curr)) {
                    continue;
                }

                visited.add(curr);

                if (curr == des) {
                    return true;
                }

                for (int key : map.get(curr)) {
                    if (!visited.contains(key)) {
                        q.add(key);
                    }
                }
            }

            return false;
        }
    }
}
