package DynamicProgramming;

public class SumOfNumbersWithUnitDigitK {
	
	class Solution {
	    public int minimumNumbers(int num, int k) {
	        if(num == 0) return 0;
	        
	        if(k % 2 == 0 && num % 2 != 0){
	            return -1;
	        }

	        int ud = num%10;
	        for(int i = 1; i <= 10; i++){
	            int m = k * i;
	            int mu = m % 10;

	            if(m <= num && mu == ud){
	                return i;
	            }else if(m > num){
	                return -1;
	            }
	        }

	        return -1;
	    }
	}
}
