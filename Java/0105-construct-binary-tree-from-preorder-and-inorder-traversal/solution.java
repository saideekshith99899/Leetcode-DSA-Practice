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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length - 1;
       return helper(preorder,0,n,inorder,0,n);     
    }

    public TreeNode helper(int[] preorder, int prelow, int prehigh , int[] inorder, int inlow, int inhigh) {
        if(prelow > prehigh) return null;
        int rootval = preorder[prelow];
        TreeNode root = new TreeNode(rootval);
        int inRootIndex = -1;
        for(int i=inlow; i<=inhigh; i++) {
            if(inorder[i] == rootval) {
               inRootIndex = i; // found i.e rootindex
                break;
            }
        }
       int leftsize = inRootIndex - inlow;      
       root.left= helper(preorder,prelow + 1, prelow + leftsize, inorder,inlow, inRootIndex-1);
       root.right = helper(preorder, prelow + leftsize + 1, prehigh, inorder,inRootIndex+1,inhigh);
        return root;

    }
}
