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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        int currentsum  = 0;
        helper(root,currentsum);
        return sum;
    }
    public void helper(TreeNode root, int currentsum) {       
        if(root == null) return ;
        currentsum = currentsum * 10 + root.val;       
        if(root.left == null && root.right == null) {
            sum = sum + currentsum;
            return;
        }
        helper(root.left, currentsum);
        helper(root.right,currentsum);
    }
}
