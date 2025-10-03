package Day_6;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	class Solution {
	    static List<List<Integer>> result = new ArrayList<>();
	    
	    public List<List<Integer>> combine(int n, int k) {
	        result.clear();
	        List<Integer> temp = new ArrayList<>();
	        helper(n, k, 1, temp);
	        return result;
	    }

	    private void helper(int n, int k, int idx, List<Integer> list) {
	        if (k == 0) {
	            result.add(new ArrayList<>(list));
	            return;
	        }
	        if (idx > n) {
	            return;
	        }
	        for (int i = idx; i <= n; i++) {
	            list.add(i);
	            helper(n, k - 1, i + 1, list);
	            list.remove(list.size() - 1); 
	        }
	    }
	}
}
