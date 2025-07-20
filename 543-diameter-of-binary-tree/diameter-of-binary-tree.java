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
    public int diameterOfBinaryTree(TreeNode root) {
        int not = diameter(root);
        return max;
    }
    public int diameter(TreeNode root)
    {
        if(root == null)return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        int self = left+right;
        max = Math.max(max,self);
        return Math.max(left,right)+1;
    }
}