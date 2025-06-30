class Solution {
    public double ans = 0.0;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); 
        }

        boolean visit[] = new boolean[n + 1];
        dfs(visit, adj, 1, target, 0, t, 1.0);
        return ans;
    }

    public void dfs(boolean visit[], ArrayList<ArrayList<Integer>> adj, int curr, int target, int time, int t, double prob) {
        visit[curr] = true;
        if (time > t) return;

        int size = 0;
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neigh = adj.get(curr).get(i);
            if (!visit[neigh]) size++;
        }

        if (curr == target) {
            if (time == t || size == 0) { 
                ans = prob;
            }
            return;
        }

        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neigh = adj.get(curr).get(i);
            if (!visit[neigh]) {
                dfs(visit, adj, neigh, target, time + 1, t, prob / size);
            }
        }
    }
}
