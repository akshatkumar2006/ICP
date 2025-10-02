package Practice_Day5;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
	public static void main(String[] args) {
		MaximumUnitsOnATruck m = new MaximumUnitsOnATruck();
		Solution solver = m.new Solution();
		int[][] boxTypes = {
				{5, 10},
				{2, 5},
				{4, 7},
				{3, 9}
		};
		
		int truckSize = 10;
		System.out.println(solver.maximumUnits(boxTypes, truckSize));
	}

	class Solution {
		public int maximumUnits(int[][] boxTypes, int truckSize) {
			Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

			int temp = truckSize;
			int i = 0;
			int unitsCount = 0;
			while (temp > 0 && i < boxTypes.length) {
				if (temp > boxTypes[i][0]) {
					temp -= boxTypes[i][0];
					unitsCount += boxTypes[i][0] * boxTypes[i][1];
				} else {
					unitsCount += temp * boxTypes[i][1];
					temp = 0;
				}
				i++;
			}

			return unitsCount;
		}
	}
}
