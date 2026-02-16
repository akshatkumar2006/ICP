package Week_6;

public class MaximumProductOfSplittedBinaryTree {

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
	    long totalSum = 0;
	    long maxProduct = 0;
	    final int mod = 1000000007;

	    public int maxProduct(TreeNode root) {
	        totalSum = treeTotalSum(root);
	        getProduct(root);
	        return (int) (maxProduct % mod);
	    }

	    public long getProduct(TreeNode root) {
	        // TODO Auto-generated method stub
	        if (root == null)
	            return 0;

	        long subtreeSum = root.val + getProduct(root.left) + getProduct(root.right);

	        long product = subtreeSum * (totalSum - subtreeSum);
	        maxProduct = Math.max(maxProduct, product);

	        return subtreeSum;
	    }

	    public long treeTotalSum(TreeNode root) {
	        // TODO Auto-generated method stub
	        if (root == null)
	            return 0;
	        return root.val + treeTotalSum(root.left) + treeTotalSum(root.right);
	    }
	}
}
