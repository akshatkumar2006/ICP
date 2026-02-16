package Week_6;

public class ReverseOddLevelsOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public TreeNode reverseOddLevels(TreeNode root) {
			recurs(root.left, root.right, 1);
			return root;
		}
		
// 		DFS
		public void recurs(TreeNode node1, TreeNode node2, int level) {
			// TODO Auto-generated method stub
			if(node1 == null || node2 == null) {
				return;
			}
			
			if((level & 1) != 0) {
				int temp = node1.val;
				node1.val = node2.val;
				node1.val = temp;
			}
			
			recurs(node1.left, node2.right, level + 1);
			recurs(node1.right, node2.left, level + 1);
		}
	}
}
