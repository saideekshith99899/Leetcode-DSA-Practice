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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list =  new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        while(!q.isEmpty()) {
            int level = q.size();
            double sum = 0;
            for(int i=0; i< level ; i++){                
                TreeNode temp = q.poll();
                sum = sum + temp.val; 
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);               
            }
            double avg = sum / level;
            list.add(avg);
              
        }

        return list;
    }
}
