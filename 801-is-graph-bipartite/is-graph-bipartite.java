class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         int v = graph.length;
        int col[] = new int[v];
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++)
        {
           for(int j=0;j<graph[i].length;j++)
           {
            
            adj.get(i).add(graph[i][j]);
           }
        }
        for(int i=0;i<v;i++)col[i] = -1;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(col[i] == -1)
            {
                que.offer(i);
                col[i] = 0;
                while(que.size() > 0)
                {
                    int curr = que.remove();
                    for(int j=0;j<adj.get(curr).size();j++){
                        int neigh = adj.get(curr).get(j);
                        if(col[neigh] == col[curr])
                        {
                            return false;
                        }
                        else if(col[neigh] == -1){
                            int next = (col[curr] == 0)?1:0;
                            col[neigh] = next;
                            que.offer(neigh);
                        }
                    }
                }
            }
        }
        return true;
    }
}