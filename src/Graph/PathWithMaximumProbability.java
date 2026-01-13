package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {

	class Solution {
		public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
			HashMap<Integer, HashMap<Integer, Double>> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				map.put(i, new HashMap<>());
			}

			for (int i = 0; i < edges.length; i++) {
				map.get(edges[i][0]).put(edges[i][1], succProb[i]);
				map.get(edges[i][1]).put(edges[i][0], succProb[i]);
			}

			class DijkstraPair {
				int vtx;
				double prob;

				public DijkstraPair(int vtx, double prob) {
					// TODO Auto-generated constructor stub
					this.vtx = vtx;
					this.prob = prob;
				}
			}

			PriorityQueue<DijkstraPair> pq = new PriorityQueue<DijkstraPair>((a, b) -> Double.compare(b.prob, a.prob));

			HashSet<Integer> visited = new HashSet<>();

			pq.add(new DijkstraPair(start_node, 1.0));

			while (!pq.isEmpty()) {
				// Remove
				DijkstraPair rp = pq.poll();

				// Ignore
				if (visited.contains(rp.vtx)) {
					continue;
				}

				// Mark Visited
				visited.add(rp.vtx);

				// SelfWork
				// System.out.println(rp);
				if (rp.vtx == end_node)
					return rp.prob;

				// Add nbrs
				for (int nbrs : map.get(rp.vtx).keySet()) {
					if (!visited.contains(nbrs)) {
						double prob = rp.prob * map.get(rp.vtx).get(nbrs);
						pq.add(new DijkstraPair(nbrs, prob));
					}
				}
			}

			return 0.0;
		}
	}
}
