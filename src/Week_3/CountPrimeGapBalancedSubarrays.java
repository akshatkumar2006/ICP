package Week_3;

import java.util.*;

public class CountPrimeGapBalancedSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimeGapBalancedSubarrays m = new CountPrimeGapBalancedSubarrays();

		Solution solver = m.new Solution();
		System.out.println(solver.primeSubarray(new int[] { 1, 2, 3 }, 1));
	}

	class Solution {
	    public static boolean[] prime;
	    static{
	        prime = seiveOfErasthonesis(50001);
	    }
	    public static boolean[] seiveOfErasthonesis(int n){
	        boolean[] arr = new boolean[n+1];
	        arr[0]=arr[1]=true;
	        for(int i=2 ; i*i<=n ; i++){
	            if(arr[i]) continue;
	            for(int j=2*i ; j<=n ; j+=i){
	                arr[j] = true;
	            }
	        }
	        return arr;
	    }
	    public int primeSubarray(int[] nums, int k) {
	        int n = nums.length;

	        TreeMap<Integer,Integer> map = new TreeMap<>();
	        Deque<Integer> primes = new ArrayDeque<>();

	        int r = 0, l = 0, ans = 0;
	        while(r < n){
	            if(!prime[nums[r]]){
	                map.put(nums[r],map.getOrDefault(nums[r],0)+1);
	                primes.add(r);
	            }
	            while(map.size()>0 && map.lastKey()-map.firstKey()>k){
	                if(!prime[nums[l]]){
	                    primes.poll();
	                    
	                    map.put(nums[l],map.get(nums[l])-1);

	                    if(map.get(nums[l])==0) map.remove(nums[l]);
	                }
	                l++;
	            }

	            if(primes.size()>=2){
	                int temp = primes.pollLast();
	                int secondLast = primes.peekLast();
	                ans += (secondLast - l + 1);
	                primes.add(temp);
	            }

	            r++;
	        }

	        return ans;
	    }
	}
}
