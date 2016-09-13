/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findLongest(root, 0);
    }
    
    private int findLongest(TreeNode root, int pre) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
           if (root.left.val == root.val + 1) {
               left = findLongest(root.left, pre + 1);
           } else {
               left = findLongest(root.left, 0);
           }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                right = findLongest(root.right, pre + 1);
            } else {
                right = findLongest(root.right, 0);
            }
        }
        return Math.max(Math.max(left, right), pre + 1);
    }
}
