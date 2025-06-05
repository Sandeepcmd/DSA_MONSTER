class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int prev = 0,i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(prev)){
                lps[i++] = ++prev;
            }
            else{
                if(prev > 0)
                  prev = lps[prev - 1];
                else
                  lps[i++] = 0;
            }
        }   
        return s.substring(0,lps[lps.length - 1]);
    }
}