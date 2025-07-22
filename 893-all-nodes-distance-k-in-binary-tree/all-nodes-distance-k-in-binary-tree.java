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
    class Pair{
        TreeNode first;
        int second;
        Pair(TreeNode first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        bfs(root,map);
        boolean visited[] = new boolean[500+1];
        List<Integer> list = new ArrayList<>();
        if(target == null)return list;
       
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(target,0));
        visited[target.val] = true;
        while(que.size() > 0)
        {
            Pair curr = que.poll();
            TreeNode node = curr.first;
            visited[node.val] = true;
            int dis = curr.second;
            if(dis == k)list.add(node.val);
            if(node.left != null && !visited[node.left.val])que.offer(new Pair(node.left,dis+1));
            if(node.right != null && !visited[node.right.val])que.offer(new Pair(node.right,dis+1));
            if(map.get(node) != null && !visited[map.get(node).val])que.offer(new Pair(map.get(node),dis+1));
            
        }        
        return list;
    }
    public void bfs(TreeNode root, HashMap<TreeNode,TreeNode> map)
    {
        if(root == null)return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(que.size() > 0)
        {
            TreeNode curr = que.remove();
            if(curr.left != null){
                map.put(curr.left,curr);
                que.offer(curr.left);
            }
            if(curr.right != null){
                map.put(curr.right,curr);
                que.offer(curr.right);
            }
        }
    }
}