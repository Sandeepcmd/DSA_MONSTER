class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int low = 0, high = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            high = Math.max(high, edge[2]);
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(mid, edges, n, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean possible(int mid, int[][] edges, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] curr = edges[i];
            int u = curr[0];
            int v = curr[1];
            int wt = curr[2];
            if (wt <= mid) {
                adj.get(u).add(new int[]{v, wt});
                adj.get(v).add(new int[]{u, wt});
            }
        }

        boolean[] visit = new boolean[n];
        int component = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                component++;
                dfs(i, adj, visit);
            }
        }

        return component <= k;
    }

    public void dfs(int curr, List<List<int[]>> adj, boolean[] visit) {
        visit[curr] = true;
        for (int[] neighbor : adj.get(curr)) {
            int next = neighbor[0];
            if (!visit[next]) {
                dfs(next, adj, visit);
            }
        }
    }
}
