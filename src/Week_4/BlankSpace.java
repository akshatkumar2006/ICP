package Week_4;

import java.util.Scanner;

public class BlankSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
			
		while(t-->0) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(getBlankSpace(arr, n));
		}
		
		sc.close();
	}

	public static int getBlankSpace(int[] arr, int n) {
		// TODO Auto-generated method stub
		int ans = 0;
		int curr = 0;
		for(int i = 0; i < n; i++) {	
			if(arr[i] == 0) {
				curr++;
			}else {
				ans = Math.max(ans, curr);
				curr = 0;
			}
		}
		
		ans = Math.max(ans, curr);
		
		return ans;
	}

}
