package Week_9;

public class NodeWithHighestEdgeScore {
    class Solution {
        public int edgeScore(int[] edges) {
            int n = edges.length;

            long[] sum = new long[n];

            for(int i = 0; i < n; i++){
                sum[edges[i]]+=i;
            }

            long maxSum = -1;
            int node = 0;

            for(int i = 0; i < n; i++){
                if(sum[i] > maxSum){
                    maxSum = sum[i];
                    node = i;
                }
            }

            return node;
        }
    }
}
