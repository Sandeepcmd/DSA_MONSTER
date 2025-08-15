class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int d[]:dp)Arrays.fill(d,-1);
        return help(n-1,m-1,text1,text2,dp);
    }
    public int help(int i,int j,String t1,String t2,int dp[][])
    {
        if(i < 0 || j < 0)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j))
        {
            return 1+help(i-1,j-1,t1,t2,dp);
        }
        return dp[i][j] = Math.max(help(i-1,j,t1,t2,dp),help(i,j-1,t1,t2,dp));
    }
}