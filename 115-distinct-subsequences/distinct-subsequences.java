class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return calculate(n - 1, m - 1, s, t, dp);
    }

    public int calculate(int i, int j, String s, String t, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            int inc = calculate(i - 1, j - 1, s, t, dp);
            int exc = calculate(i - 1, j, s, t, dp);
            return dp[i][j] = inc + exc;
        }

        return dp[i][j] = calculate(i - 1, j, s, t, dp);
    }
}
