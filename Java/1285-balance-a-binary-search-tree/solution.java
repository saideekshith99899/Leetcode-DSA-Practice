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
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int left = 0;
        int right = list.size()-1;
        return bst(left,right,list);
    }
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    private TreeNode bst(int left, int right, List<Integer> list){
        if(left > right) return null;       
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = bst(left,mid-1,list);
        root.right = bst(mid+1,right,list);
        return root;
    }
}
