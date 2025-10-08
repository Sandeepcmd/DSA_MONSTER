class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int [n+1][2];
        for(int d[] : dp)Arrays.fill(d,-1);
        return stock(0, 0, prices, n,dp);
    }

    public int stock(int i, int buy, int[] prices, int n,int dp[][]) {
        if (i == n) return 0;
        if(dp[i][buy] != -1)return dp[i][buy];
        int profit = 0;

        if (buy == 0) {
            
            profit = Math.max(
                -prices[i] + stock(i + 1, 1, prices, n,dp),
                stock(i + 1, 0, prices, n,dp)
            );
        } else {
           
            profit = Math.max(
                prices[i] + stock(i + 1, 0, prices, n,dp),
                stock(i + 1, 1, prices, n,dp)
            );
        }

        return dp[i][buy] = profit;
    }
}
