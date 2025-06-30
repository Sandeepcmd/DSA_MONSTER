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
    public int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int a = path(root);
        return ans;
    }
    public int path(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,path(root.left));
        int right = Math.max(0,path(root.right));
        int self = left+right+root.val;
        ans = Math.max(ans,self);
        return Math.max(left,right)+root.val;
    }
}