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
    HashMap<Integer, Integer> inmap = new HashMap<>();
    for(int i=0; i<inorder.length; i++){

        inmap.put(inorder[i],i);
    }
    int n = inorder.length-1;
    TreeNode root = BuildTree(preorder,0,n,inorder,0,n,inmap);
    return root;
    }

    public TreeNode  BuildTree(int[] preorder, int preLow, int preEnd, int[] inorder,int inLow, int inEnd, HashMap<Integer, Integer> inmap) {

        if(preLow > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preLow]);
        int inRoot = inmap.get(root.val);
        int numsLeft = inRoot - inLow;
        root.left = BuildTree(preorder, preLow+1, preLow+numsLeft, inorder, inLow, inRoot-1,inmap);
        root.right = BuildTree(preorder, preLow+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inmap);

        return root;
    }
}
