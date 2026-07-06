/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int tiltsum = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return tiltsum;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int leftsum = helper(root.left);
        int rightsum = helper(root.right);
        tiltsum = tiltsum + Math.abs(leftsum - rightsum);
        return leftsum + rightsum + root.val;
    }
}
