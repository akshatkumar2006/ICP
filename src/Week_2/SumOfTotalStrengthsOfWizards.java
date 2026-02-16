package Week_2;

public class SumOfTotalStrengthsOfWizards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfTotalStrengthsOfWizards m = new SumOfTotalStrengthsOfWizards();
		
		Solution solver = m.new Solution();
		
		int[] arr = {1, 3, 1, 2};
		System.out.println(solver.totalStrength(arr));
	}
	
	class Solution {
	    public int totalStrength(int[] strength) {
	    	int[] prefix = calculatePrefixSum(strength);
	    	
	        return 0;
	    }

		private int[] calculatePrefixSum(int[] strength) {
			// TODO Auto-generated method stub
			int n = strength.length;
			
			int[] prefix = new int[n + 1];
			
			for(int i = 0; i < n; i++) {
				prefix[i] = prefix[i - 1] + strength[i];
			}
			
			return prefix;
		}
	}
}
