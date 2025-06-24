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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)return new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(root);
        while(st1.size() > 0)
        {
             TreeNode curr = st1.pop();
             st2.push(curr.val);
             if(curr.left != null)
             {
                st1.push(curr.left);
             }
             if(curr.right != null)
             {
                st1.push(curr.right);
             }
        }
        List<Integer> list = new ArrayList<>();
        while(st2.size() > 0)
        {
            list.add(st2.pop());
        }
        return list;
    }
}