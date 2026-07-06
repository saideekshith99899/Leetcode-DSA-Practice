import java.util.*;

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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        long secondMin = helper(root,root.val);
        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }

    public long helper(TreeNode root, int rootval){
        if(root == null) return Long.MAX_VALUE;
        if(root.val > rootval) {
            return root.val;
        }
        long left = helper(root.left,rootval);
        long right = helper(root.right, rootval);
        return Math.min(left,right);
    }
}
