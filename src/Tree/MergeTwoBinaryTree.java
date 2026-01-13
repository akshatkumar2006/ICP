package Tree;

public class MergeTwoBinaryTree {
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
		public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
			return merge(root1, root2);
		}

		public TreeNode merge(TreeNode node1, TreeNode node2) {
			// TODO Auto-generated method stub
			
			return node1;
		}
	}
}
