package Practice_Day7;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {
	class Solution {
	    public List<String> letterCasePermutation(String s) {
	        List<String> ll = new ArrayList<>();
	        substring(s, 0, "", ll);
	        return ll;
	    }
	    public static void substring(String s, int i, String ans,List<String> ll){
	        if(i==s.length()){
	            ll.add(ans);
	            return;
	        }

	        char ch = s.charAt(i);
	        if(ch>='0' && ch<='9'){
	            substring(s,i+1,ans+ch,ll);
	        }else{
	            substring(s,i+1,ans+ch,ll);
	            if(ch>='A' && ch<='Z'){
	                ch = (char)(ch + 32);
	                substring(s,i+1,ans+ch,ll);
	            }else{
	                ch = (char)(ch - 32);
	                substring(s,i+1,ans+ch,ll);
	            }
	        }
	    }
	}
}
