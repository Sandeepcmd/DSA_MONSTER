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
        int level = -1;
        int start = 0;
        int last = 0;
        int max = 0;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root,0));
        while(que.size()>0)
        {
            int n = que.size();
            start = que.peek().second;
            while(n-- > 0)
            {
                 Pair curr = que.remove();
                 TreeNode node = curr.first;
                 last = curr.second;
                 if(node.left != null)
                 {
                    que.add(new Pair(node.left,2*last+1));
                 }
                 if(node.right != null)
                 {
                    que.add(new Pair(node.right,2*last+2));
                 }
                 max = Math.max(max,last-start+1);
            }
        }
        max = Math.max(max,last-start+1);
        return max;
    }
}