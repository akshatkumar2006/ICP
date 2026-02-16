package Week_4;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt(), k = sc.nextInt();
			
			long[] a = new long[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			
			Arrays.sort(a);
			
			long[] prefix = new long[n + 1];
			
			for(int i = 0; i < n; i++) {
				prefix[i + 1] = prefix[i] + a[i];
			}
			
			long ans = 0;
			
			for(int i = 0; i <= k; i++) {
				ans = Math.max(ans, prefix[n - (k - i)] - prefix[2*i]);
			}
			
			System.out.println(ans);
		}
		
		sc.close();
	}

}
