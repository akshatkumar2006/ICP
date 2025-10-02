package Day_5;

public class BoatsToSavePeople {
	class Solution {
		public int numRescueBoats(int[] people, int limit) {
//	        Arrays.sort(people);
//	        int count=0;
//	        int i=0;
//	        int j=people.length-1;
//	        while(i<=j){
//	            if(people[i]+people[j]<=limit){
//	                count++;
//	                i++;
//	                j--;
//	            }
//	            else{
//	                count++;
//	                j--;
//	            }
//	        }
//	        return count;

			int[] arr = new int[limit + 1];
			for (int w : people) {
				arr[w]++;
			}
			int boats = 0;
			int i = 1, j = limit;
			while (i <= j) {
				if (arr[i] <= 0)
					i++;
				else if (arr[j] <= 0)
					j--;
				else if (i + j <= limit) {
					arr[i]--;
					arr[j]--;
					boats++;
				} else {
					arr[j]--;
					boats++;
				}
			}
			return boats;

		}
	}
}
