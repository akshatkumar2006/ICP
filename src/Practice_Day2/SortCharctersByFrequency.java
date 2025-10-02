package Practice_Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharctersByFrequency {
	class Solution {
	    public String frequencySort(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        for(char ch : s.toCharArray()){
	            map.put(ch, map.getOrDefault(ch, 0) + 1);
	        }

	        List<Character> ll = new ArrayList<>(map.keySet());

	        Collections.sort(ll, (a,b) -> map.get(b) - map.get(a));

	        StringBuilder sb = new StringBuilder();

	        for(char ch : ll){
	            for(int i = 0; i<map.get(ch); i++){
	                sb.append(ch);
	            }
	        }

	        return sb.toString();
	    }
	}
}
