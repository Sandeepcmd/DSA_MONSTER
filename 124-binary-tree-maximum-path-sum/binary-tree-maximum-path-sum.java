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
       int ans = maxPathSum1(root);
       return max; 
    }
    public int maxPathSum1(TreeNode root)
    {
         if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,maxPathSum1(root.left));
        int right = Math.max(0,maxPathSum1(root.right));
        int self = root.val + left + right;
        max = Math.max(max,self);
        return Math.max(left,right)+root.val;
    }
}