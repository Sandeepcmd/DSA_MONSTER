class Solution {
    private static final int WALL = 1;
    private static final int GUARD = 2;
    private static final int GUARDED = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] w : walls) {
            grid[w[0]][w[1]] = WALL;
        }

        for (int[] g : guards) {
            grid[g[0]][g[1]] = GUARD;
        }

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int[] g : guards) {
            for (int[] dir : directions) {
                dfs(grid, g[0] + dir[0], g[1] + dir[1], dir, m, n);
            }
        }

        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }

        return unguarded;
    }

    private void dfs(int[][] grid, int x, int y, int[] dir, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == WALL || grid[x][y] == GUARD) {
            return;
        }

        if (grid[x][y] == 0) {
            grid[x][y] = GUARDED;
        }

        dfs(grid, x + dir[0], y + dir[1], dir, m, n);
    }
}
