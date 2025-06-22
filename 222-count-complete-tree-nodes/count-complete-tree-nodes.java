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
    public int getLeft(TreeNode root)
    {
        TreeNode temp = root;
        int lh = 0;
        while(temp != null)
        {
            temp = temp.left;
            lh++;
        }
        return lh;
    }
     public int getRight(TreeNode root)
    {
        TreeNode temp = root;
        int rh = 0;
        while(temp != null)
        {
            temp = temp.right;
            rh++;
        }
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int lh = getLeft(root);
        int rh = getRight(root);
        if(lh == rh)return (int)Math.pow(2,lh)-1;

        return countNodes(root.left)+countNodes(root.right)+1;
    }
}