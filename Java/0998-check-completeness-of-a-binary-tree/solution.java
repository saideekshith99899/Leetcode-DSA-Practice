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
class pair {
    TreeNode node;
    int index;
    pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
 }

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,1));

        int count = 0;
        int lastIndex = 0;

        while(!q.isEmpty()) {
            pair p = q.poll();
            TreeNode node = p.node;
            int index = p.index;
            count++;
            lastIndex = index;
            if(node.left != null) {
                q.add(new pair(node.left, 2 * index));
            }

            if(node.right != null) {
                q.add(new pair(node.right, 2 * index + 1));
            }
        }
        return lastIndex == count;
    }
}
