package Practice_Day11;

public class RemoveNthNodeFromEnd {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode temp = new ListNode(0, head);
			ListNode dummy = temp;
			
			for(int i = 0; i < n; i++) {
				head = head.next;
			}
			
			while(head != null) {
				dummy = dummy.next;
				head = head.next;
			}
			
			dummy.next = dummy.next.next;
			
			return temp.next;
		}
	}
}
