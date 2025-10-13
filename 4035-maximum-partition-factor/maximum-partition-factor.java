import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private int n;
    private int[][] points;

    /**
     * Finds the maximum possible partition factor over all valid splits of the points.
     *
     * @param points A 2D array where points[i] = [xi, yi].
     * @return The maximum partition factor.
     */
    public int maxPartitionFactor(int[][] points) {
        this.n = points.length;
        this.points = points;

        // Per the problem statement, for n=2, the only split results in a
        // partition factor defined as 0.
        if (n == 2) {
            return 0;
        }

        // Binary search for the maximum possible partition factor.
        long low = 0;
        long high = 400_000_001L; // A safe upper bound for Manhattan distance
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPartitionPossible(mid)) {
                // A factor of `mid` is achievable, try for a larger one.
                ans = mid;
                low = mid + 1;
            } else {
                // `mid` is too high, try a smaller factor.
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    /**
     * Checks if a partition factor of `d` is possible by modeling the problem
     * as a graph and checking for bipartiteness.
     *
     * @param d The target partition factor to check.
     * @return True if a partition with factor `d` is possible, false otherwise.
     */
    private boolean isPartitionPossible(long d) {
        // Build a graph where an edge connects points with Manhattan distance < d.
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Use long to prevent overflow during distance calculation.
                long dist = (long) Math.abs(points[i][0] - points[j][0]) + (long) Math.abs(points[i][1] - points[j][1]);
                if (dist < d) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        // Check if the graph is bipartite using BFS.
        // colors[i] = 0 (uncolored), 1 (group A), -1 (group B).
        int[] colors = new int[n];
        
        // Iterate through all nodes to handle disconnected components.
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // If uncolored, start a new traversal.
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    for (int v : adj[u]) {
                        if (colors[v] == 0) {
                            colors[v] = -colors[u]; // Assign opposite color
                            queue.add(v);
                        } else if (colors[v] == colors[u]) {
                            // An edge connects two nodes of the same color,
                            // indicating an odd-length cycle.
                            return false; // Not bipartite
                        }
                    }
                }
            }
        }
        
        // If the graph is bipartite, a valid partition exists.
        return true;
    }
}