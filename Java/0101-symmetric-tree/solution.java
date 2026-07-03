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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        TreeNode leftsubtree = root.left;
        TreeNode rightsubtree = root.right;
    return helper(leftsubtree,rightsubtree);

    }

    public boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;

        if(p.val == q.val){
            return helper(p.left,q.right) && helper(p.right,q.left);
        }
        return false;
    }

}
