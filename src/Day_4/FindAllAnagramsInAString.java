package Day_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
	class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int k = p.length();
            if(n<k) return ans;

            int []freqp = new int[26];
            int []freqs = new int[26];

            for(char c : p.toCharArray()){
                freqp[c-'a']++;
            }

            for(int i =0 ; i<k ; i++){
                freqs[s.charAt(i)-'a']++;
            }

            if(Arrays.equals(freqp , freqs)){
                ans.add(0);
            }

            //sliding window

            for(int i = k ; i<n ; i++){
                freqs[s.charAt(i)-'a']++;
                freqs[s.charAt(i-k)-'a']--;

                if(Arrays.equals(freqs , freqp)){
                    ans.add(i-k+1);
                }
            }
            return ans;
        }
    }
}
