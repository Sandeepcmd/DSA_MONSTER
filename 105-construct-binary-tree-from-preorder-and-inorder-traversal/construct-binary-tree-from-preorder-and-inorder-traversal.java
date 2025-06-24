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
    public int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        return build(map,preorder,0,n-1);
    }
    public TreeNode build(HashMap<Integer,Integer> map,int [] preorder,int start,int end)
    {
        if(start > end)return null;
        int i = map.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = build(map,preorder,start,i-1);
        root.right = build(map,preorder,i+1,end);
        return root;
    }
}