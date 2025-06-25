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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int inorder[] = new int[n];
        for(int i=0;i<n;i++)inorder[i] = preorder[i];
        Arrays.sort(inorder);
        for(int i=0;i<n;i++)map.put(inorder[i],i);
        return construct(map,inorder,preorder,0,n-1);
    }
    public TreeNode construct(HashMap<Integer,Integer> map ,int[] inorder,int[]preorder,int start,int end){
        if(start > end)return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int i = map.get(preorder[idx]);
        idx++;
        root.left = construct(map,inorder,preorder,start,i-1);
        root.right = construct(map,inorder,preorder,i+1,end);
        return root;
    }
}