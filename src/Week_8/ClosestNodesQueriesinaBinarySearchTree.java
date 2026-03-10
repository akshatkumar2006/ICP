package Week_8;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNodesQueriesinaBinarySearchTree {
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
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);

            List<List<Integer>> ans = new ArrayList<>();

            for (int q : queries) {
                int ceilIdx = lowerBound(nums, q);      // first >= q
                int floorIdx = upperBound(nums, q) - 1; // last <= q

                int ceil = (ceilIdx == nums.size()) ? -1 : nums.get(ceilIdx);
                int floor = (floorIdx < 0) ? -1 : nums.get(floorIdx);

                ans.add(Arrays.asList(floor, ceil));
            }

            return ans;
        }

        private void inorder(TreeNode node, List<Integer> nums) {
            if (node == null) return;
            inorder(node.left, nums);
            nums.add(node.val);
            inorder(node.right, nums);
        }

        // First index where nums[i] >= target
        private int lowerBound(List<Integer> nums, int target) {
            int l = 0, r = nums.size();

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

        // First index where nums[i] > target
        private int upperBound(List<Integer> nums, int target) {
            int l = 0, r = nums.size();

            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums.get(mid) > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }

//        public int minELement(TreeNode node, int target) {
//            if (node == null) {
//                return Integer.MIN_VALUE;
//            }
//
//            if (node.val <= target) {
//                return Math.max(node.val, minELement(node.right, target));
//            } else {
//                return minELement(node.left, target);
//            }
//        }
//
//        public int maxELement(TreeNode node, int target) {
//            if (node == null) {
//                return Integer.MAX_VALUE;
//            }
//
//            if (node.val >= target) {
//                return Math.min(node.val, maxELement(node.left, target));
//            } else {
//                return maxELement(node.right, target);
//            }
//        }
    }
}
