package Graph;

import  java.util.*;

@SuppressWarnings("unused")
public class FindEventualSafePath {
	
	class Solution {
	    public List<Integer> eventualSafeNodes(int[][] graph) {
	        int n = graph.length;

			boolean[] vis = new boolean[n];
			boolean[] path = new boolean[n];
			boolean[] check = new boolean[n];
	        for(int i = 0; i < n; i++){
				if(!vis[i]){
					dfs(i, graph, vis, path, check);
				}
			}

			List<Integer> ll = new ArrayList<>();
			for(int i = 0; i < n; i++){
				if(check[i]){
					ll.add(i);
				}
			}
			return ll;
	    }

		private boolean dfs(int i, int[][] graph, boolean[] vis, boolean[] path, boolean[] check) {
			vis[i] = true;
			path[i] = true;
			check[i] = false;
			for(int nbrs : graph[i]){
				if(!vis[nbrs]){
					if(dfs(nbrs, graph, vis, path, check) == true){
						return true;
					}
				} else if (path[nbrs]) {
					return true;
				}
			}
			path[i] = false;
			check[i] = true;
			return false;
		}
	}
}
