class Solution {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        int count = (int) Math.ceil((double) n / m); 

        StringBuilder s = new StringBuilder(a);
        for (int i = 1; i < count; i++) {
            s.append(a);
        }
        if (check(s.toString(), b)) {
            return count;
        }
        s.append(a); 
        if (check(s.toString(), b)) {
            return count + 1;
        }
        return -1;
    }

    private boolean check(String s, String b) {
        int[] lps = LPS(b);
        int i = 0;
        int j = 0; 

        while (i < s.length()) {
            if (s.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            if (j == b.length()) {
                return true; 
            } else if (i < s.length() && s.charAt(i) != b.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false; 
    }
    private int[] LPS(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        int i = 1;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
