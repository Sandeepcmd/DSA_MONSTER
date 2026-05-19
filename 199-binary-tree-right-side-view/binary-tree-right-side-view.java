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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        if(root == null)return ans;
        while(que.size() > 0){
            int n = que.size();
            while(n-- >0){
                TreeNode curr = que.remove();
                list.add(curr.val);
                if(curr.left != null)que.offer(curr.left);
                if(curr.right != null)que.offer(curr.right);
            }
            ans.add(list.get(list.size()-1));
            list = new ArrayList<>();
        }
        return ans;
    }
}