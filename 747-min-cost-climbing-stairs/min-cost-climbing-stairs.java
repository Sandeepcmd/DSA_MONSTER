class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(help(n-1,cost,dp),help(n-2,cost,dp));
    }
    public int help(int i,int cost[],int dp[])
    {
        if(i<0)return 0;
        if(i == 0 || i == 1)return cost[i];
        if(dp[i] != -1)return dp[i];
        int one = help(i-1,cost,dp);
        int two = Integer.MAX_VALUE;
        if(i>=2)two = help(i-2,cost,dp);
        return dp[i] = cost[i] + Math.min(one,two);
    }
}