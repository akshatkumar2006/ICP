package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Basics {

	static HashMap<Integer, ArrayList<Integer>> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map = new HashMap<>();
	
		int[][] edges = {
				{1, 2},
				{1, 0},
				{0, 2},
				{2, 3},
				{2, 4}
		};
		
		for(int[] ele : edges) {
//			System.out.println(ele[0] +" " + ele[1]);
			if(!map.containsKey(ele[0])) {
				map.put(ele[0], new ArrayList<Integer>());
			}
			if(!map.containsKey(ele[1])) {
				map.put(ele[1], new ArrayList<Integer>());
			}
			map.get(ele[0]).add(ele[1]);
			map.get(ele[1]).add(ele[0]);
		}
		
//		System.out.println(1);
		
//		display(map);
		
//		dfs(map);
		
		boolean[] visited = new boolean[map.size()];
		
		dfs(map, visited, 0);
	}
	
	public static void dfs(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, int node) {
		visited[node] = true;
		
		System.out.print(node + " ");
		
		for(int nbrs : map.get(node)) {
			if(!visited[nbrs]) {
				dfs(map, visited, nbrs);
			}
		}
	}
	
	public static void dfs(HashMap<Integer, ArrayList<Integer>> map) {
		// TODO Auto-generated method stub
		int n = map.size();
		
		Stack<Integer> st = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		
		for(int src = 0; src < n; src++) {
			if(visited.contains(src)) continue;
			
			st.push(src);
			
			while(!st.isEmpty()) {
				int r = st.pop();
				
				if(visited.contains(r)) {
					continue;
				}
				
				visited.add(r);
				
				System.out.print(r + " ");
				
				for(int ele : map.get(r)) {
					if(!visited.contains(ele)) {
						st.push(ele);
					}
				}
			}
		}
	}
	
	public static void display(HashMap<Integer, ArrayList<Integer>> map) {
		// TODO Auto-generated method stub
		for(int key : map.keySet()) {
			System.out.print(key + "-> ");
			for(int ele : map.get(key)) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

}
