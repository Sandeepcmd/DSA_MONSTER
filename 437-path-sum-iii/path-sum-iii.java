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
    public int c = 0;

    public int pathSum(TreeNode root, int target) {
        HashMap<Long, Integer> map = new HashMap<>();   
        map.put(0L, 1);                                 
        help(root, 0L, target, map);                   
        return c;
    }
    public void help(TreeNode root, long sum, int target, HashMap<Long, Integer> map) {
        if (root == null) return;
        sum = sum + root.val;
        if (map.containsKey(sum - (long) target)) {
            c += map.get(sum - (long) target);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        help(root.left,  sum, target, map);
        help(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
    }
}