class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int d[] : dp)
        {
            Arrays.fill(d,-1);
        }
        return dfs(n,m,grid,0,0,dp);
    }
    public int dfs(int n,int m,int[][] grid,int i,int j,int dp[][])
    {
        if(i>=n || j>=m || grid[i][j] == 1)
        {
            return 0;
        }
        if(i == n-1 && j == m-1)
        {
            return 1;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int right = dfs(n,m,grid,i,j+1,dp);
        int down = dfs(n,m,grid,i+1,j,dp);
        return dp[i][j] = right+down;
    }
}