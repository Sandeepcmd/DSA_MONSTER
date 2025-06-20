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
    class Info {
        TreeNode node;
        int level;
        int hd;
        Info(TreeNode node,int level,int hd)
        {
            this.node = node;
            this.level = level;
            this.hd = hd;
        }
    }
    class Pair{
        int first;
        int level;
        Pair(int first,int level)
        {
            this.first = first;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Info> que = new LinkedList<>();
        que.offer(new Info(root, 0, 0));
        while (que.size() > 0) {
            Info curr = que.remove();
            TreeNode node = curr.node;
            int hd = curr.hd;
            int level = curr.level;
            min = Math.min(min,hd);
            max = Math.max(max,hd);
            map.computeIfAbsent(hd, k -> new ArrayList<>());
            map.get(hd).add(new Pair(node.val, level));
            if (node.left != null) {
                que.offer(new Info(node.left, level + 1, hd - 1));
            }
            if (node.right != null) {
                que.offer(new Info(node.right, level + 1, hd + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            List<Pair> temp = new ArrayList<>();
            temp = map.get(i);
            Collections.sort(temp,(p1,p2)->{
                  if(p1.level == p2.level)
                  {
                    return p1.first-p2.first;
                  }
                  else
                  {
                    return p1.level-p2.level;
                  }
            });
            List<Integer> temp2 = new ArrayList<>();
            for(Pair p : temp)
            {
                temp2.add(p.first);
            } 
            ans.add(temp2);
        }
        return ans;
    }
}