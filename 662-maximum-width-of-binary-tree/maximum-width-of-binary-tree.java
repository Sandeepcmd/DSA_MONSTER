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
        TreeNode first;
        int second;
        Pair(TreeNode first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(root,0));
        while(que.size()>0)
        {
            int n = que.size();
            int start = que.peek().second;
            int last = 0;
            while(n-->0)
            {
                 Pair p = que.remove();
                 TreeNode curr = p.first;
                 int dis = p.second;
                 last = dis;
                 if(curr.left != null)
                 {
                    que.offer(new Pair(curr.left,2*dis+1));
                 }
                 if(curr.right != null)
                 {
                    que.offer(new Pair(curr.right,2*dis+2));
                 }
            }
            int width = last - start;
            max = Math.max(max,width);
        }
        return max+1;

    }
}