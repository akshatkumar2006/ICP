package Week_8;

import com.sun.source.tree.Tree;

public class DeleteLeavesWithAGivenValue {

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
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            return recurs(root, target);
        }

        public TreeNode recurs(TreeNode node, int target){
            if(node == null) return null;

            node.left = recurs(node.left, target);
            node.right = recurs(node.right, target);

            if (node.left == null && node.right == null && node.val == target){
                return null;
            }

            return node;
        }
    }
}
