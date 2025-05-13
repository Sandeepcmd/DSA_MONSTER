class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        int mod = 1000000007;

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] nextFreq = new int[26];
            for (int j = 0; j < 26; j++) {
                int count = freq[j];
                if (count == 0) continue;
                if (j != 25) {
                    nextFreq[j + 1] = (nextFreq[j + 1] + count) % mod;
                } else {
                    nextFreq[0] = (nextFreq[0] + count) % mod;
                    nextFreq[1] = (nextFreq[1] + count) % mod;
                }
            }
            freq = nextFreq;
        }

        int total = 0;
        for (int val : freq) {
            total = (total + val) % mod;
        }

        return total;
    }
}
