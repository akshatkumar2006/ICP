package Day_10;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementingStackUsingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class MyStack {
		
		Queue<Integer> q1;
		Queue<Integer> q2;

	    public MyStack() {
	        q1 = new LinkedList<>();
	        q2 = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	        q1.add(x);
	    }
	    
	    public int pop() {
	        if(q1.isEmpty()) {
	        	return -1;
	        }
	        
	        while(q1.size() != 1) {
	        	q2.add(q1.peek());
	        	q1.remove();
	        }
	        
	        int res = q1.remove();
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	        
	        return res;
	    }
	    
	    public int top() {
	    	if (q1.isEmpty())
	            return -1;

	        while (q1.size() != 1) {
	            q2.add(q1.peek());
	            q1.remove();
	        }
	        
	        int temp = q1.remove();
	        q2.add(temp);
	        Queue<Integer> t = q1;
	        q1 = q2;
	        q2 = t;
	        return temp;
	    }
	    
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	}
}
