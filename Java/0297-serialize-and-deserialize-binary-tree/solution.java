/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> que = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node == null) {
                result.append("null ");
                continue;
            }

            result.append(node.val).append(" ");
            que.add(node.left);
            que.add(node.right);
        }

        return result.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        Queue<TreeNode> que = new LinkedList<>();

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        que.add(root);

        int i = 1;

        while (!que.isEmpty() && i < values.length) {
            TreeNode node = que.poll();

            // left child
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                que.add(left);
            }
            i++;

            // right child
            if (i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                que.add(right);
            }
            i++;
        }

        return root;
    }
}
