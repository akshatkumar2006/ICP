package Week_7;

public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            recurs(root);
            return root;
        }

        public void recurs(TreeNode node){
            if(node == null) return;

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            recurs(node.left);
            recurs(node.right);
        }
    }
}
