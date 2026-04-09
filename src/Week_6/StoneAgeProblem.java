package Week_6;

import java.util.Scanner;

public class StoneAgeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long sum = 0;
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            sum+=a[i];
        }

        int[] updates = new int[n];
        int allUpdates = -1;
        long allUpdatesValue = 0;

        for(int i = 0; i < q; i++){
            int t = sc.nextInt();
            if(t == 1){
                int idx = sc.nextInt();
                long v = sc.nextLong();
                idx--;
                if(updates[idx] < allUpdates){
                    a[idx] = allUpdatesValue;
                }

                sum-=a[idx];
                a[idx] = v;
                sum+=v;
                updates[idx] = i + 1;
            }else if(t == 2){
                long v = sc.nextLong();
                allUpdatesValue = v;
                allUpdates = i + 1;
                sum = (long) (n * v);
            }

            System.out.println(sum);
        }
    }
}
