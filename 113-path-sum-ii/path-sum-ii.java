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
        help(root, target, list, temp);
        return list;
    }

    private void help(TreeNode root, int target, List<List<Integer>> list, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);
        //int rem = target - root.val;
        if (root.left == null && root.right == null && target-root.val == 0) {
            list.add(new ArrayList<>(temp));
        } else {
            help(root.left, target-root.val, list, temp);
            help(root.right, target-root.val, list, temp);
        }

        temp.remove(temp.size() - 1);
    }
}
