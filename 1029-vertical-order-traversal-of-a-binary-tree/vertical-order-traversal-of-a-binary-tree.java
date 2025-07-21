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
    class Pair{
        int val;
        int level;
        Pair(int val,int level)
        {
            this.val = val;
            this.level = level;
        }
    }
    class Pair2{
        TreeNode node;
        int hd;
        Pair2(TreeNode node,int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer,List<Pair>> map = new HashMap<>();
        Queue<Pair2> que = new LinkedList<>();
        que.offer(new Pair2(root,0));
        int level = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(que.size() > 0)
        {
            int n = que.size();
            while(n-- > 0)
            {
                 Pair2 curr = que.remove();
                TreeNode node = curr.node;
                int hd = curr.hd;
                min = Math.min(min,hd);
                max = Math.max(max,hd);
                if(map.containsKey(hd)){
                    List<Pair> ans = map.get(hd);
                    ans.add(new Pair(node.val,level));
                    map.put(hd,ans);
                }
                else
                {
                    List<Pair> temp = new ArrayList<>();
                    temp.add(new Pair(node.val,level));
                    map.put(hd,temp);
                }
                if(node.left != null)que.offer(new Pair2(node.left,hd-1));
                if(node.right != null)que.offer(new Pair2(node.right,hd+1));

            }
            level++;
        }
        for(int i=min;i<=max;i++)
        {
            List<Pair> temp = new ArrayList<>();
            temp = map.get(i);
             Collections.sort(temp,(Pair p,Pair q)->{
                if(p.level == q.level)return p.val-q.val;
                else return p.level-q.level;
            });
            List<Integer> temp2 = new ArrayList<>();
            for(int j=0;j<temp.size();j++)
            {
                Pair p = temp.get(j);
                temp2.add(p.val);
            }
            list.add(temp2);
           
        }
        return list;
    }
}