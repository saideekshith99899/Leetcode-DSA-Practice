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
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> id = new LinkedList<>();

        node.offer(root);
        id.offer(0); // level 0 start
        int maxwidth = 0;

        while(!node.isEmpty()) {
            int n = node.size();
            int first = 0, last = 0;

            for(int i = 0; i< n; i++) {
                TreeNode curr = node.poll();
                int currid = id.poll();
                if(i == 0) first = currid;
                if(i== n-1) last = currid;

                if(curr.left != null) {
                    node.offer(curr.left);
                    id.offer(2*currid + 1);
                }
                if(curr.right != null){
                    node.offer(curr.right);
                    id.offer(2*currid + 2);
                }

            }
            maxwidth = Math.max(maxwidth, last-first+1);
        }

        return maxwidth;
    }
}
