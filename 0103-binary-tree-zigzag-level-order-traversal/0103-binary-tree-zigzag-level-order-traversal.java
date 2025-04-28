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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        int level=1;
        while(que.size()>0)
        {
            int n=que.size();
            List<Integer> list=new ArrayList<>();
            while(n-- > 0)
            {
                TreeNode curr=que.remove();
                list.add(curr.val);
                 if(curr.left!=null)
                  {
                    que.offer(curr.left);
                  }
                  if(curr.right != null)
                  {
                    que.offer(curr.right);
                  }
            }
             if(level%2==0)
               {
                  Collections.reverse(list);
               }
            level++;
            ans.add(list);
        }
         return ans;

    }
}