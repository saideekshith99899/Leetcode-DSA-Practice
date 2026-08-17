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
    class pair{
        TreeNode node;
        int depth;
        pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
      pair p = solve(root,0); // depth = 0
      return p.node;
    }
    public pair solve(TreeNode root, int depth){
        if(root == null) return new pair (null,depth);
        pair left = solve(root.left, depth + 1);
        pair right = solve(root.right, depth + 1);
        if(left.depth == right.depth) {
            return new pair(root,left.depth);
        }
        else{
            return left.depth > right.depth ? left : right;
        }
    }
}
