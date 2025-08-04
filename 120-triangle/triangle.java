class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return dfs(triangle, 0, 0, memo);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int down = dfs(triangle, i + 1, j, memo);
        int diagonal = dfs(triangle, i + 1, j + 1, memo);

        memo[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        return memo[i][j];
    }
}