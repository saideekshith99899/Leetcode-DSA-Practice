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
    public int pathSum(TreeNode root, long targetSum) {
        if(root == null) return count;
        helper(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }
    public void helper(TreeNode root, long targetSum){
        if(root == null) return;
        if(targetSum == root.val){
            count++;
        }
        targetSum = targetSum - root.val;
        helper(root.left,targetSum);
        helper(root.right,targetSum);
    }
}
