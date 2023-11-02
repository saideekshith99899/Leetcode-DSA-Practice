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
    int result =0;
    public int averageOfSubtree(TreeNode root) {

        avgroot(root);
        return result;
        
    }

    private int[] avgroot(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }

        int[] l = avgroot(node.left);
        int[] r = avgroot(node.right);

        int sum = l[0]+r[0]+node.val;
        int c = l[1]+r[1]+1;

        if((sum/c) == node.val){
            result++;
        }

        return new int[] {sum,c};
    }
}
