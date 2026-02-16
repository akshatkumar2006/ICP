package Week_3;

public class TimeNeededToBuyTickets {

	public static void main(String[] args) {
		TimeNeededToBuyTickets m = new TimeNeededToBuyTickets();

		Solution solver = m.new Solution();
		System.out.println(solver.timeRequiredToBuy(new int[] { 15, 66, 3, 47, 71, 27, 54, 43, 97, 34, 94, 33, 54, 26,
				15, 52, 20, 71, 88, 42, 50, 6, 66, 88, 36, 99, 27, 82, 7, 72 }, 18));
	}

	class Solution {
		public int timeRequiredToBuy(int[] tickets, int k) {
			int n = tickets.length;

			int mask = tickets[k];

			int time = 0;

			for (int i = 0; i < k; i++) {
				if (tickets[i] < mask) {
					time += tickets[i];
				} else {
					time += mask;
				}
			}

			time += mask;
			for (int i = k + 1; i < n; i++) {
				if (tickets[i] >= mask) {
					time += (mask - 1);
				} else {
					time += tickets[i];
				}
			}

			return time;
		}
	}
}
