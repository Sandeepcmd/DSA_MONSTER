class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] memo = new Integer[n][m];
        return dfs(word1, word2, n - 1, m - 1, memo);
    }

    public int dfs(String word1, String word2, int n, int m, Integer[][] memo) {
        if (n < 0) return m + 1;
        if (m < 0) return n + 1; 

        if (memo[n][m] != null) return memo[n][m];

        if (word1.charAt(n) == word2.charAt(m)) {
            memo[n][m] = dfs(word1, word2, n - 1, m - 1, memo);
        } else {
            int delete = dfs(word1, word2, n - 1, m, memo);
            int replace = dfs(word1, word2, n - 1, m - 1, memo);
            int insert = dfs(word1, word2, n, m - 1, memo);
            memo[n][m] = 1 + Math.min(delete, Math.min(replace, insert));
        }
        return memo[n][m];
    }
}
