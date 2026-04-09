package Week_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfWaysToArriveDestination {
    class Solution {
        class DijkstraPair {
            int u;
            long cost;

            public DijkstraPair(int u, long cost) {
                this.u = u;
                this.cost = cost;
            }
        }

        public int countPaths(int n, int[][] roads) {
            int MOD = 1_000_000_007;

            HashMap<Integer, HashMap<Integer, Long>> graph = new HashMap<>();

            for (int i = 0; i < n; i++) {
                graph.put(i, new HashMap<>());
            }

            for (int[] edge : roads) {
                int u = edge[0];
                int v = edge[1];
                long c = edge[2];

                graph.get(u).put(v, c);
                graph.get(v).put(u, c);
            }

            PriorityQueue<DijkstraPair> pq = new PriorityQueue<>((a, b)->{
                return Long.compare(a.cost,b.cost);
            });
            pq.offer(new DijkstraPair(0, 0));

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0L;
            long[] ways = new long[n];
            ways[0] = 1L;
            while (!pq.isEmpty()) {
                DijkstraPair rp = pq.poll();
                int u = rp.u;
                long cost = rp.cost;

                if (dist[u] < cost) {
                    continue;
                }

                for (int nbrs : graph.get(u).keySet()) {
                    long ncost = graph.get(u).get(nbrs) + cost;

                    if (dist[nbrs] > ncost) {
                        dist[nbrs] = ncost;
                        ways[nbrs] = ways[u];
                        pq.offer(new DijkstraPair(nbrs, ncost));
                    } else if (dist[nbrs] == ncost) {
                        ways[nbrs] = (ways[nbrs] + ways[u]) % MOD;
                    }
                }
            }
            return (int) ways[n - 1];
        }
    }
}
