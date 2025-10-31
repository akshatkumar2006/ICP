package Day_10;

import java.util.ArrayList;
import java.util.List;

public class CarsFleet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int carFleet(int target, int[] position, int[] speed) {
	        int n = position.length;
	        List<double[]> cars = new ArrayList<>();
	        
	        for (int i = 0; i < n; i++) {
	            double time = (double) (target - position[i]) / speed[i];
	            cars.add(new double[]{position[i], time});
	        }
	        
	        cars.sort((a, b) -> Double.compare(b[0], a[0]));
	        
	        double prev = cars.get(0)[1];
	        int ans = 1;
	        for (int i = 1; i < n; i++) {
	            if (cars.get(i)[1] > prev) {
	                ans++;
	                prev = cars.get(i)[1];
	            }
	        }
	        return ans;
	    }
	}
}
