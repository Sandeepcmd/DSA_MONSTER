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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int ans = dfs(root);
        return max;
    }
    public int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        int self = left+right+root.val;
        max = Math.max(max,self);
        // max = Math.max(max,left);
        // max = Math.max(max,right);
        return Math.max(left,right) + root.val;

    }
}