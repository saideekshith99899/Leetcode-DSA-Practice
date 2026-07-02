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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> list = new ArrayList<>();
       List<Integer> sublist = new ArrayList<>();
       int currentsum = 0;
       helper(root,targetSum,currentsum,sublist,list);
       return list;
    }
    public void helper(TreeNode root, int targetsum, int currentsum, List<Integer> sublist, List<List<Integer>> list) {
        if(root == null) return;
        currentsum = currentsum + root.val;
        sublist.add(root.val);
        if(root.left == null && root.right == null){
            if(targetsum == currentsum){
                list.add(new ArrayList<>(sublist));
            }
        }
        else{
            helper(root.left,targetsum,currentsum,sublist,list);
            helper(root.right,targetsum,currentsum,sublist,list);
        }
        sublist.remove(sublist.size()-1); // backtracking
    }
}
