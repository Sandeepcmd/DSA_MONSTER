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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index)
        {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root,0));
        int max = Integer.MIN_VALUE;
        while(que.size() > 0)
        {
            int n = que.size();
            int first = que.peek().index;
            int second = n;
            while(n-- > 0)
            {
                Pair curr = que.remove();
                TreeNode node = curr.node;
                int index = curr.index;
                second = index;
                if(node.left != null)que.offer(new Pair(node.left,2*index+1));
                if(node.right != null)que.offer(new Pair(node.right,2*index+2));
            }
            max = Math.max(max,second-first+1);
        }
        return max;
    }
}