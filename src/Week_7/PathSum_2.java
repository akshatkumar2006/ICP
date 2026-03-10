package Week_7;

import java.util.ArrayList;
import java.util.List;

public class PathSum_2 {
    public static void main(String[] args) {

    }

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
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> ll = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            path(root, targetSum);
            return ans;
        }

        public void path(TreeNode node, int targetSum) {
            // base
            if (node == null) {
                return;
            }

            targetSum -= node.val;
            ll.add(node.val);

            if (node.left == null && node.right == null && targetSum == 0) {
                ans.add(new ArrayList<Integer>(ll));
            }

            // left
            path(node.left, targetSum);
            // right
            path(node.right, targetSum);

            ll.remove(ll.size() - 1);
        }
    }
}
