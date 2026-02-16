package Week_5;

import java.util.Stack;

public class FlattenLinkedList {
	
	class Node {
	    public int val;
	    public Node next;
	    public Node child;
	};
	
	class Solution {
	    public Node flatten(Node head) {
//	        Node head2 = new Node();
//	        head2.val = head.val;
//	        head2.child = head.child;
//	        head2.next = head.next;
	        
	        Node temp = head;
	        
	        Stack<Node> st = new Stack<>();
	        st.push(temp);
	        
	        while(temp != null) {
	        	if(temp.child != null) {
	        		if(temp.next != null) {
	        			st.push(temp.next);
	        		}
	        		temp.next = temp.child;
	        		temp.child = null;
	        	}
	        	
	        	if(temp.next == null && !st.isEmpty()) {
	        		temp.next = st.pop();
	        	}
	        	
	        	temp = temp.next;
	        }
	        
	        return head;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
