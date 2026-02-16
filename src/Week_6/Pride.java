package Week_6;

import java.util.Scanner;

class Pride {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println(pride(a, n));

		sc.close();

	}

	public static int pride(int[] a, int n) {
		// TODO Auto-generated method stub
		int ones = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 1) {
				ones++;
			}
		}

		if (ones > 0) {
			return n - ones;
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int gcd = a[i];
			for (int j = i + 1; j < n; j++) {
				gcd = GCD(gcd, a[j]);

				if (gcd == 1) {
					int curr = i + (n - j - 1) + 2 * (j - i);
					ans = Math.min(ans, curr);
				}
			}
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public static int GCD(int a, int b) {
		// TODO Auto-generated method stub
		while (a > 0 && b > 0) {
			if (a > b) {
				a = a % b;
			} else {
				b = b % a;
			}
		}

		if (a == 0) {
			return b;
		}
		
		return a;
	}
}
