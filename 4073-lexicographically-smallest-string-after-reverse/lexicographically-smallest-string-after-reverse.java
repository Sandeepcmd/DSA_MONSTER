class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String best = s; 
        
        for (int k = 1; k <= n; k++) {
            String s1 = new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
            if (s1.compareTo(best) < 0) best = s1;
        }
        for (int k = 1; k <= n; k++) {
            String s2 = s.substring(0, n - k) + new StringBuilder(s.substring(n - k)).reverse().toString();
            if (s2.compareTo(best) < 0) best = s2;
        }

        return best;
    }
}
