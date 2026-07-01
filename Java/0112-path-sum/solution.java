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
    public boolean hasPathSum(TreeNode root, int targetSum) {
    int currentsum = 0;
    return helper(root,targetSum,currentsum); 
    }

    public boolean helper(TreeNode root, int targetsum, int currentsum){
        
        if(root == null) return false;
        currentsum  = currentsum + root.val;
        if(root.left == null && root.right == null) {
            return currentsum == targetsum;
        }
        return helper(root.left, targetsum,currentsum) 
                || helper(root.right, targetsum, currentsum);
    
    }
}
