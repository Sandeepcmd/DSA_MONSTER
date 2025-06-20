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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list;
        int level = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty())
        {
            int n = que.size();
            List<Integer> temp = new ArrayList<>();
            while(n-->0)
            {
                TreeNode curr = que.remove();
                temp.add(curr.val);
                 if(curr.left != null)que.offer(curr.left);
                 if(curr.right != null)que.offer(curr.right);
            }
            if(level%2 != 0)Collections.reverse(temp);
            level++;
            list.add(temp);
        }
        return list;
    }
}