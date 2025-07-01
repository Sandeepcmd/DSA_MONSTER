class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int n = word.length();
        int c = 0;
        for(int i=0;i<n-1;i++)
        {
            if(word.charAt(i) == word.charAt(i+1))
            {
                c++;
            }
        }
        return ans+c;
    }
}