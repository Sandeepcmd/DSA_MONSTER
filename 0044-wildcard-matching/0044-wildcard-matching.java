class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] memo = new Boolean[n + 1][m + 1]; 
        return dfs(s, p, n - 1, m - 1, memo);
    }

    public boolean dfs(String s, String p, int n, int m, Boolean[][] memo) {
        if (n < 0 && m < 0) return true;
        if (m < 0) return false;
        if (n < 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        if (memo[n + 1][m + 1] != null) return memo[n + 1][m + 1];

        if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '?') {
            return memo[n + 1][m + 1] = dfs(s, p, n - 1, m - 1, memo);
        } else if (p.charAt(m) == '*') {
            boolean matchZero = dfs(s, p, n, m - 1, memo);
            boolean matchOneOrMore = dfs(s, p, n - 1, m, memo);
            return memo[n + 1][m + 1] = matchZero || matchOneOrMore;
        } else {
            return memo[n + 1][m + 1] = false;
        }
    }
}
