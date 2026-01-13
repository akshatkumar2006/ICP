package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExist {
	
	class Solution {
	    public boolean validPath(int n, int[][] edges, int source, int destination) {
	        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

	        for(int i = 0; i < n; i++){
	            graph.put(i, new ArrayList<>());
	        }

	        for(int[] edge : edges){
	            graph.get(edge[0]).add(edge[1]);
	            graph.get(edge[1]).add(edge[0]);
	        }

	        return isPathExist(graph, source, destination);
	    }

	    public boolean isPathExist(HashMap<Integer, ArrayList<Integer>> map, int src, int des){
	        Queue<Integer> q = new LinkedList<>();

	        HashSet<Integer> visited = new HashSet<>();

	        q.offer(src);

	        while(!q.isEmpty()){
	            int r = q.poll();

	            if(visited.contains(r)){
	                continue;
	            }

	            visited.add(r);

	            if(r == des) return true;

	            for(int nbrs : map.get(r)){
	                if(!visited.contains(nbrs)){
	                    q.offer(nbrs);
	                }
	            }
	        }

	        return false;
	    }
	}
}
