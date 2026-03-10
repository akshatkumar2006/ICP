package Week_9;

import Week_7.InvertBinaryTree;

import java.util.*;

public class CourseSchedule_IV {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for(int i = 0; i < numCourses; i++){
                map.put(i, new ArrayList<>());
            }

            for(int[] edge : prerequisites){
                int u = edge[0];
                int v = edge[1];

                map.get(u).add(v);
            }

            boolean[][] isReachable = new boolean[numCourses][numCourses];

            for(int i = 0; i < numCourses; i++){
                boolean[] vis = new boolean[numCourses];

                bfs(map, i, vis);

                isReachable[i] = vis;
            }

            List<Boolean> res = new ArrayList<>();
            for(int[] q : queries){
                int u = q[0];
                int v = q[1];

                if(isReachable[u][v]){
                    res.add(true); // answer query using isReachable arr
                }else{
                    res.add(false);
                }
            }
            return res;
        }

        public void bfs(HashMap<Integer, ArrayList<Integer>> map, int src, boolean[] vis){
            Queue<Integer> q = new LinkedList<>();
            q.add(src);

            while(!q.isEmpty()){
                int curr = q.poll();

                if(vis[curr]) continue;

                vis[curr] = true;

                for(int nbrs : map.get(curr)){
                    if(!vis[nbrs]){
                        q.offer(nbrs);
                    }
                }
            }
        }
    }
}
