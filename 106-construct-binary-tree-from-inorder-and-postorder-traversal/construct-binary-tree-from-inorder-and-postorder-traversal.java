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
    public int idx;  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        idx = n-1;
        return build(map,postorder,0,n-1);
    }
    public TreeNode build( HashMap<Integer,Integer> map, int[] postorder,int l,int r)
    {
        if(l > r)return null;
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int mid = map.get(root.val);
        root.right = build(map,postorder,mid+1,r);
        root.left = build(map,postorder,l,mid-1);
        
        return  root;
    }
}