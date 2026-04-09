package Week_6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MatrixGame {
    static int[][] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            a = new int[n][m];

            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                    if(a[i][j] == 1) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }

            int minn = Math.min(n - row.size(), m - col.size());

            if(minn % 2 == 0){
                System.out.println("Vivek");
            }else{
                System.out.println("Ashish");
            }
        }
    }
}
