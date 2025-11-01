class Solution {
    public int characterReplacement(String s, int k) {
        char arr[] = s.toCharArray();
        int freq[] = new int[26];
        int ans = 0;
        int i = 0, j = 0;
        int n = s.length();
        int maxFreq = 0;
        while (j < n) {
            int idx = arr[j] - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            int len = j - i + 1;
            int changes = len - maxFreq;
            if (changes <= k) {
                ans = Math.max(ans, len);
            } else {
                freq[arr[i] - 'A']--;
                i++; 
            }
            j++; 
        }
        return ans;
    }
}