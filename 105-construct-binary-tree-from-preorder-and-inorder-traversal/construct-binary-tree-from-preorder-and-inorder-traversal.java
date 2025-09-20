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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 0;
        while(j < n)
        {
            map.put(inorder[j],j);
            j++;
        }
        int i[] = new int[1];
        i[0] = 0;
      return build(preorder,map,i,0,n-1,n); 
    }
    public TreeNode build(int[] preorder,HashMap<Integer,Integer> map,int i[],int l ,int r,int n){
       if(l > r || i[0] >= n)  return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
         int index = map.get(root.val);
         root.left = build(preorder,map,i,l,index-1,n);
         root.right = build(preorder,map,i,index+1,r,n);
        return root;
    }
}