class Solution {
    public int xorAfterQueries(int[] a, int[][] q) {
        int mod = 1_000_000_007;
        int n = a.length;
        int m = q.length;

        int[][] mat = q;

        for (int i = 0; i < m; i++) {
            int l = mat[i][0];
            int r = mat[i][1];
            int k = mat[i][2];
            int v = mat[i][3];

            for (int j = l; j <= r; j += k) {
                a[j] = (int)((1L * a[j] * v) % mod);
            }
        }

        int x = 0;
        for (int val : a) {
            x ^= val;
        }

        return x;
    }
}