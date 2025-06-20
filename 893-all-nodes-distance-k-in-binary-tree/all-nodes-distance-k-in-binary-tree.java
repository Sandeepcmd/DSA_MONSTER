/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair
    {
        TreeNode first;
        int second;
        Pair(TreeNode first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0)
        {
            int n = queue.size();
            while(n-->0)
            {
                TreeNode curr = queue.remove();
                if(curr.left != null)
                {
                    map.put(curr.left,curr);
                    queue.offer(curr.left);
                }
                 if(curr.right != null)
                {
                    map.put(curr.right,curr);
                    queue.offer(curr.right);
                }
            }
        }
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(target,0));
         while(que.size() > 0)
        {
            int n = que.size();
            while(n-->0)
            {
                Pair p = que.remove();
                TreeNode curr = p.first;
                int dist = p.second;
                if(dist == k)
                {
                    list.add(curr.val);
                }
                if(curr.left != null && !set.contains(curr.left))
                {
                    set.add(curr.left);
                    que.offer(new Pair(curr.left,dist+1));
                }
                if(curr.right != null && !set.contains(curr.right))
                {
                    set.add(curr.right);
                    que.offer(new Pair(curr.right,dist+1));
                }
                if(map.containsKey(curr) && !set.contains(map.get(curr)))
                {
                      set.add(map.get(curr));
                      que.offer(new Pair(map.get(curr),dist+1));
                }
            }
        }
        return list;
    }

}