package Week_10;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FoodStamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] A = new int[n];
        int[] D = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            D[i] = sc.nextInt();
        }

        sc.close();

        System.out.println(getTaste(A, D, n, m));
    }

    public static int getTaste(int[] A, int[] D, int n, int m){
        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> q[0] - p[0]);

        for(int i = 0; i < n; i++){
            pq.add(new int[]{A[i], D[i]});
        }

        int ans = 0;
        while(m > 0){
            int[] curr = pq.poll();
            if(curr[0] <= 0){
                break;
            }
            ans+=curr[0];
            pq.add(new int[]{curr[0] - curr[1], curr[1]});
            m--;
        }

        return ans;
    }
}
