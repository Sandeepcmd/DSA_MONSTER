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
    public TreeNode recoverFromPreorder(String s) {
        Stack<TreeNode> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i < n)
        {
            int depth = 0;
            while(i < n && s.charAt(i) == '-'){
                i++;
                depth++;
            }
            int val = 0;
            while(i < n && Character.isDigit(s.charAt(i))){
                val = val*10 + s.charAt(i)-'0';
                i++;
            }
            TreeNode node = new TreeNode(val);
            while (st.size() > depth) {
                st.pop();
            }
             if (!st.isEmpty()) {
                if (st.peek().left == null) st.peek().left = node;
                else st.peek().right = node;
            }
            st.push(node);
        }
         while (st.size() > 1) st.pop();
        return st.peek();
    }
}