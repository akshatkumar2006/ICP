package Day_2;

public class ValidSquareNumber {
	class Solution {
	    public boolean isPerfectSquare(int num) {
	        long l = 1, h = num;

	        while (l <= h) {
	            long mid = l + (h - l) / 2;
	            if (mid > num/mid) {
	                h = mid - 1;
	            } else if (mid*mid == num) {
	                return true;
	            } else {
	                l = mid + 1;
	            }
	        }

	        return false;
	    }
	}
}
