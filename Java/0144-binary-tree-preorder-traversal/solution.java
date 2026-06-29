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
    public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    if(root == null) return result;;
    while(!stack.empty()) {
        root = stack.pop();
        result.add(root.val);
        if(root.right != null) {
            stack.push(root.right);
        }
        if(root.left != null) {
            stack.push(root.left);
        }
    }
    return result;
    }
}
