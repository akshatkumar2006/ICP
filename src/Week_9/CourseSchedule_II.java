package Week_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_II {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for(int i = 0; i < numCourses; i++){
                map.put(i, new ArrayList<>());
            }

            for(int[] edge : prerequisites){
                int u = edge[0];
                int v = edge[1];

                map.get(v).add(u);
            }

            int[] ans = new int[numCourses];

            int[] inDegree = calculateInDegree(map);

            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(inDegree[i] == 0){
                    q.offer(i);
                }
            }

            int count = 0;
            while(!q.isEmpty()){
                int curr = q.poll();

                ans[count++] = curr;

                for(int nbrs : map.get(curr)){
                    inDegree[nbrs]--;
                    if(inDegree[nbrs] == 0){
                        q.offer(nbrs);
                    }
                }
            }

            return count == numCourses ? ans : new int[]{};
        }

        public int[] calculateInDegree(HashMap<Integer, ArrayList<Integer>> map){
            int[] inDegree = new int[map.size()];

            for(int i = 0; i < map.size(); i++){
                for(int nbrs : map.get(i)){
                    inDegree[nbrs]++;
                }
            }

            return inDegree;
        }
    }
}
