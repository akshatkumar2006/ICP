package Practice_Day1;

public class SecondLargestDigitInAString {
	class Solution {
	    public int secondHighest(String s) {
	        int c = 2;
	        for(char ch = '9'; ch>='0'; ch--){
	            if(s.indexOf(ch)!=-1){
	                c--;
	                if(c == 0){
	                    return ch - '0';
	                }
	            }
	        }
	        return -1;
	    }
	}
}
