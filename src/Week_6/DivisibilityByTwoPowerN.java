package Week_6;

import java.util.*;

public class DivisibilityByTwoPowerN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
            long currentFactors = 0;

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                currentFactors += countFactorsOfTwo(a);
            }

            List<Integer> ll = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int factors = countFactorsOfTwo(i);
                if (factors > 0) {
                    ll.add(factors);
                }
            }

            Collections.sort(ll, Collections.reverseOrder());

            int operations = 0;
            if (currentFactors < n) {
                for (int add : ll) {
                    currentFactors += add;
                    operations++;
                    if (currentFactors >= n) break;
                }
            }

            if (currentFactors >= n) {
                System.out.println(operations);
            } else {
                System.out.println("-1");
            }
        }
    }

    private static int countFactorsOfTwo(int num) {
        int count = 0;
        while (num > 0 && num % 2 == 0) {
            count++;
            num /= 2;
        }
        return count;
    }
}
