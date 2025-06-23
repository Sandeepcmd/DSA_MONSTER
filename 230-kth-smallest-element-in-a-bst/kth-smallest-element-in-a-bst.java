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
    public int ans = 0;
    public int K;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        small(root);
        return ans;
    }
    public void small(TreeNode root)
    {
        if(root == null)return;
        small(root.left);
        if(--K == 0)
        {
           ans = root.val;
           return ;
        }
        small(root.right);
    }
}