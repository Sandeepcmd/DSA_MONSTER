class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
            {
                que.offer(i);
            }
        }
        while(que.size() > 0)
        {
            int curr = que.remove();
            list.add(curr);
            for(int i=0;i<adj.get(curr).size();i++)
            {
                int neigh = adj.get(curr).get(i);
                indegree[neigh]--;
                if(indegree[neigh] == 0)que.offer(neigh);
            }
        }
        Collections.sort(list);
        return list;
    }
}