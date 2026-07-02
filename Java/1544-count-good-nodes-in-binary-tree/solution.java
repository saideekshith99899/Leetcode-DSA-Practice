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
    public int goodNodes(TreeNode root) {    
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int maxsofar){
        int count = 0;
        if(root == null) return 0;
        maxsofar  = Math.max(root.val,maxsofar);
        if(maxsofar <= root.val) {
            count++;
        }
        return count + helper(root.left, maxsofar) + helper(root.right,maxsofar);
    }
}
