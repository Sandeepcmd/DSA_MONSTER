class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1];
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);
        
        return stock(0, 0, k, prices, n, dp);
    }

    public int stock(int i, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (i == n || cap == 0)
            return 0;
        
        if (dp[i][buy][cap] != -1)
            return dp[i][buy][cap];

        int profit;
        if (buy == 0) {
           
            profit = Math.max(
                -prices[i] + stock(i + 1, 1, cap, prices, n, dp),
                stock(i + 1, 0, cap, prices, n, dp)
            );
        } else {
            profit = Math.max(
                prices[i] + stock(i + 1, 0, cap - 1, prices, n, dp),
                stock(i + 1, 1, cap, prices, n, dp)
            );
        }

        return dp[i][buy][cap] = profit;
    }
}