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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key) {
            // traverse right side
            root.right  = deleteNode(root.right, key);
        }
        else if(root.val > key) {
            // traverse left side
            root.left = deleteNode(root.left, key);
        }
        else{ // equal root.val == val;
           
            if(root.left == null) return root.right;
            else if(root.right  == null) return root.left;
            else {
                // no null both exist now maintain property 
                TreeNode succ = root.right; //  alwyas choose right beacuse left is small 
                while(succ.left != null) {
                    succ = succ.left;
                }
                root.val = succ.val;
                root.right = deleteNode(root.right,succ.val);

            }
        }
        return root;
    }
}
