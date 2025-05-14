class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return chori(nums,n,dp);
    }
    public int chori(int nums[],int n,int dp[])
    {
        if(n < 0)
        {
            return 0;
        }
        if(n == 0)
        {
            return nums[n];
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        int rob = nums[n]+chori(nums,n-2,dp);
        int notrob = chori(nums,n-1,dp);
        return dp[n] = Math.max(rob,notrob);
    }
}