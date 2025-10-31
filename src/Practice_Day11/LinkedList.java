package Practice_Day11;

public class LinkedList {
	
	class Node{
		int val;
		Node next;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		public Node(int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
		}
		
		public Node(int val, Node next) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.next = next;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public void addFirst(int item) {
		Node nn = new Node(item);
		
		if (size == 0) {
			head = nn;
			tail = nn;
			size++;
		} else {
			nn.next = head;
			head = nn;
			size++;
		}
	}
	
	public void addLast(int item) {
		if(size == 0) {
			addFirst(item);
		}else {
			Node nn = new Node();
			nn.val = item;
			tail.next = nn;
			tail = nn;
			size++;
		}
	}
	
	public int get(int idx) throws Exception {
		return getNode(idx).val;
	}
	
	private Node getNode(int k) throws Exception {
		if (k < 0 || k >= size) {
			throw new Exception("K is not in range");
		}
		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		return temp;
	}
}
