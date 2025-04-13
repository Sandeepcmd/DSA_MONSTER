import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        String mid = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1 && mid.equals("")) {
                mid = String.valueOf((char) (i + 'a'));
                freq[i]--;
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char) (i + 'a'));
            }
        }

        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf.toString() + mid + secondHalf;
    }
}
