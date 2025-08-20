class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int b = 0;
        int dp[][] = new int[n+1][2];
        for(int d[] : dp)
        {
            Arrays.fill(d,-1);
        }
        return help(0,b,prices,dp);
    }
    public int help(int i,int b,int []prices,int dp[][])
    {
        if(i >= prices.length)return 0;
        int buy = 0;
        int notbuy = 0;
        int sell = 0;
        int hold = 0;
        if(dp[i][b] != -1)
        {
            return dp[i][b];
        }
        if(b == 0)
        {
           buy = -prices[i]+help(i+1,1,prices,dp);
           notbuy = help(i+1,0,prices,dp);
        }
        else{
            sell = prices[i]+help(i+1,0,prices,dp);
            hold = help(i+1,1,prices,dp);
        }
        return dp[i][b] = Math.max(hold,Math.max(sell,Math.max(buy,notbuy)));
    }
}