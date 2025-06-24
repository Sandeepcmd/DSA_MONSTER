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
        idx = n-1;
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        return build(map,0,n-1,postorder);
    }
    public TreeNode build(HashMap<Integer,Integer> map,int start,int end,int postorder[])
    {
        if(start > end)return null;
        int root_Val = postorder[idx];
        idx--;
        int i = map.get(root_Val);
        TreeNode root = new TreeNode(root_Val);
        root.right = build(map,i+1,end,postorder);
        root.left = build(map,start,i-1,postorder);
        return root;
    }
}