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
    
    String smallest = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        return smallest;
    }
    public void dfs(TreeNode root,String path) {
        if(root == null) return;
        path = path+(char)('a'+root.val);
        if(root.left == null && root.right == null) {
            String sb = new StringBuilder(path).reverse().toString();
            if(smallest == null || sb.compareTo(smallest) < 0) {
                smallest = sb;
            }
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
    }
}
