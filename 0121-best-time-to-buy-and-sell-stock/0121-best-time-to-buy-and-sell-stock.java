class Solution {
    public int maxProfit(int[] prices) 
    {
         int n = prices.length;
         int small = prices[0];
         int max = 0;
         for(int i=1;i<n;i++)
         {
             if(prices[i]<small)
             {
                small = prices[i];
             }
             max=Math.max(max,prices[i]-small);
         }
         return max;
    }
}