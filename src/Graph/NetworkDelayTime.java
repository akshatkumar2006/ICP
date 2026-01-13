package Graph;

public class NetworkDelayTime {
	
	class Solution {
	    public int networkDelayTime(int[][] times, int n, int k) {
	        if (n <= 0)
	            return -1;

	        final int INF = 1_000_000_000;
	        int[] dist = new int[n + 1];

	        for (int i = 1; i <= n; i++)
	            dist[i] = INF;

	        dist[k] = 0;

	        for (int i = 0; i < n - 1; i++) {
	            boolean changed = false;

	            for (int[] e : times) {
	                int u = e[0], v = e[1], w = e[2];
	                int du = dist[u];
	                int alt = du + w;

	                if (du < INF && alt < dist[v]) {
	                    dist[v] = alt;
	                    changed = true;
	                }
	            }

	            if (!changed)
	                break;
	        }

	        int max = 0;
	        for (int i = 1; i <= n; i++) {
	            int d = dist[i];
	            if (d == INF)
	                return -1;
	            if (d > max)
	                max = d;
	        }

	        return max;
	    }
	    // public int networkDelayTime(int[][] times, int n, int k) {
	    //     HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	    //     for(int i = 1; i <= n; i++){
	    //         map.put(i, new HashMap<>());
	    //     }

	    //     for(int[] a : times){
	    //         int u = a[0], v = a[1], cost = a[2];

	    //         map.get(u).put(v, cost);
	    //     }

	    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	    //     HashSet<Integer> visited = new HashSet<>();

	    //     pq.offer(new int[]{k, 0});

	    //     int time = -1;

	    //     while(!pq.isEmpty()){
	    //         int[] rp = pq.poll();

	    //         if(visited.contains(rp[0])) continue;

	    //         time = rp[1];

	    //         visited.add(rp[0]);

	    //         for(int nbrs : map.get(rp[0]).keySet()){
	    //             if(!visited.contains(nbrs)){
	    //                 pq.add(new int[]{nbrs, rp[1] + map.get(rp[0]).get(nbrs)});
	    //             }
	    //         }
	    //     }

	    //     return visited.size() == n ? time : -1;
	    // }
	}
}
