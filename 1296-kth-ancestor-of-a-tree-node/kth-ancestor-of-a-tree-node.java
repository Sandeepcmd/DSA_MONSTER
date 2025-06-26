class TreeAncestor {
    public int dp[][];
    public TreeAncestor(int n, int[] parent) {
        dp = new int[18][n+1];
        for(int d[] : dp)
        {
            Arrays.fill(d,-1);
        }
       for(int i=0;i<n;i++)
       {
        dp[0][i] = parent[i];
       }
       for(int i=1;i<18;i++)
       {
        for(int j=0;j<n+1;j++)
        {
            if(dp[i-1][j] != -1)
            {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }
       }

    }
    
    public int getKthAncestor(int node, int k) {
        int K = k;
        int count = 0;
        while(K!=0 && node != -1)
        {
            if((K&1) != 0)
            {
                node = dp[count][node];
            }
            count++;
           K = K >> 1;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */