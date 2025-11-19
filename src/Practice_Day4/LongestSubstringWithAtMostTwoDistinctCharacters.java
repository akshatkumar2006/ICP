package Practice_Day4;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class LongestSubstringWithAtMostTwoDistinctCharacters {
//	class Solution {
//	    public int lengthOfLongestSubstringTwoDistinct(String s) {
//	        Map<Character, Integer> cnt = new HashMap<>();
//	        int n = s.length();
//	        int ans = 0;
//	        for (int i = 0, j = 0; i < n; ++i) {
//	            char c = s.charAt(i);
//	            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
//	            while (cnt.size() > 2) {
//	                char t = s.charAt(j++);
//	                cnt.put(t, cnt.get(t) - 1);
//	                if (cnt.get(t) == 0) {
//	                    cnt.remove(t);
//	                }
//	            }
//	            ans = Math.max(ans, i - j + 1);
//	        }
//	        return ans;
//	    }
//	}
	
	class Solution {
	    public String minWindow(String s, String t) {
	        if(s.length()<t.length()){
	            return "";
	        }
	        int[] freq=new int[128];
	        for(int i=0;i<t.length();i++){
	            freq[t.charAt(i)]++;
	        }
	        int total=t.length();
	        int ei=0;
	        int si=0;
	        int count=0;
	        int ans=Integer.MAX_VALUE;
	        StringBuilder str=new StringBuilder();
	        String pp="";
	        int[] a=new int[128];
	        while(si<=ei && ei<s.length()){
	            a[s.charAt(ei)]++;
	            str.append(s.charAt(ei));
	            if(a[s.charAt(ei)]<=freq[s.charAt(ei)]){
	                count++;
	            }
	            if(count==total){
	                int b=ei-si;
	                if(b<ans){
	                    ans=b;
	                    pp=str.toString();
	                }
	            }
	            while(count==total && si<=ei){
	                a[s.charAt(si)]--;
	                str.deleteCharAt(0);
	                if(a[s.charAt(si)]<freq[s.charAt(si)]){
	                    count--;
	                }
	                if(count==total){
	                    int n=ei-si;
	                    if(n<=ans){
	                        ans=n;
	                        pp=str.toString();
	                    }
	                }
	                si++;
	            }
	            ei++;
	        }
	        
	        return pp;
	    }
	}
}
