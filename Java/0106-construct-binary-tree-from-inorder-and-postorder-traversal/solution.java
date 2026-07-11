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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    HashMap<Integer,Integer> inmap = new HashMap<>();
    for(int i=0; i<inorder.length; i++) {
        inmap.put(inorder[i],i);
    }
    
    TreeNode root = BuildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inmap);
    return root;

    }

    public TreeNode BuildTree(int[] inorder, int inLow, int inEnd, int[] postorder, int postLow, int postEnd, HashMap<Integer, Integer> inmap) {

        if(inLow > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inmap.get(root.val);
        int numsLeft = inRoot - inLow;

        root.left = BuildTree(inorder,inLow,inRoot-1,postorder, postLow, postLow+numsLeft-1, inmap);
        root.right = BuildTree(inorder,inRoot+1,inEnd,postorder,postLow+numsLeft,postEnd - 1,inmap);
        return root;

    }
}
