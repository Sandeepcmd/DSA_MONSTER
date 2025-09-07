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
    public String serialize(TreeNode root) 
    {
        if(root == null)return "#";
        StringBuilder ob = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (que.size() > 0) {
            TreeNode curr = que.remove();
            if (curr == null) {
                ob.append("#,");
            } else {
                ob.append(curr.val).append(",");
                que.offer(curr.left);
                que.offer(curr.right);
            }

        }
        return ob.toString();
    }
    public TreeNode deserialize(String data) 
    {
        if (data.equals("#")) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < values.length && !values[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));