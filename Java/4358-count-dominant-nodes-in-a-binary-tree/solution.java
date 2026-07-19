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
    int count = 0;  
    public int countDominantNodes(TreeNode root) {        
        helper(root);
        return count;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftmax = helper(root.left);
        int rightmax = helper(root.right);
        if(root.val >= leftmax && root.val >= rightmax) count++;
        return Math.max(root.val, Math.max(leftmax,rightmax));
    }
}
