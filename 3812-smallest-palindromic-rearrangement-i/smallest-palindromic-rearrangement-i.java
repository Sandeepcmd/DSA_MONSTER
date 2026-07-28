class Solution {
    public String smallestPalindrome(String s) {
        int n =s.length();
        int map[] = new int[26];
       for (char c : s.toCharArray()) {
           map[c - 'a']++;
        }
        String ans = "";
        int map2[] = new int[26];
        for(int i=0;i<26;i++){
            map2[i] = map[i]/2;
            map[i] = map[i]%2;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<map2[i];j++){
                char c = (char)(i + 'a');
                ans += c;
            }
        }
        String reversed = new StringBuilder(ans).reverse().toString();
        for(int i=0;i<26;i++){
            if(map[i] > 0){
                char c = (char)(i + 'a');
                ans += c;
            }
        }
        ans += reversed;
        return ans;
    }
}