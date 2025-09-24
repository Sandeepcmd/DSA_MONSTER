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
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(root,0,target,list,temp);
        return list;
    }
    public void help(TreeNode root,int sum,int target,List<List<Integer>>list,List<Integer> temp)
    {
        if(root == null)
        {
            return ;
        }
        temp.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == target)
        {
            list.add(new ArrayList<>(temp));
             temp.remove(temp.size() - 1);
            return;
        }
        help(root.left,sum,target,list,temp);
        help(root.right,sum,target,list,temp);
        temp.remove(temp.size()-1);
    }
}