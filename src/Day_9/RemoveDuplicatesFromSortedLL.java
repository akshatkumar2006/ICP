package Day_9;

public class RemoveDuplicatesFromSortedLL {

	public static void main(String[] args) {

	}

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
	    public ListNode deleteDuplicates(ListNode head) {
	        ListNode dummy = new ListNode(-101, head);
	        ListNode prev = dummy;
	        ListNode curr = head;
	        while (curr != null && prev != null) {
	            if (curr.val == prev.val) {
	                prev.next = curr.next;
	                ListNode temp = curr.next;
	                curr.next = null;
	                curr = temp;
	            }else{
	                prev = prev.next;
	                curr = curr.next;
	            }
	        }

	        return dummy.next;
	    }
	}
}
