class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] tmap = new int[128];
        int[] smap = new int[128];
        int i = 0, j = 0;
        int start = 0;
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < m; k++) {
            tmap[t.charAt(k)]++;
        }

        while (i < n) {
            smap[s.charAt(i)]++;

            while (check(smap, tmap) && j <= i) {
                if (i - j + 1 < ans) {
                    ans = i - j + 1;
                    start = j;
                }
                smap[s.charAt(j)]--;
                j++;
            }

            i++;
        }

        if (ans == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + ans);
    }

    public boolean check(int[] smap, int[] tmap) {
        for (int i = 0; i < 128; i++) {
            if (tmap[i] > 0 && smap[i] < tmap[i]) {
                return false;
            }
        }
        return true;
    }
}