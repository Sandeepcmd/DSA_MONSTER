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

    
    public TreeNode deserialize(String data) {
         if (data == null || data.length() == 0 || data.equals("#")) {
            return null;
        }
          String arr[] = data.split(",");
          int n = arr.length;
          int i = 1;
          Queue<TreeNode> que = new LinkedList<>();
          TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
          que.offer(root);
          while(que.size() > 0 && i < arr.length)
          {
            TreeNode curr = que.poll();
            if(i != n && !arr[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = left;
                que.offer(left);
            }
            i++;
             if(i != n && !arr[i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = right;
                que.offer(right);
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