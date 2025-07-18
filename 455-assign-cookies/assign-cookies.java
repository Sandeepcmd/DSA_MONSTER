class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while(i < n && j < m)
        {
           if(s[j] >= g[i])
           {
             ans++;
             i++;
             j++;
           }
           else
           {
            j++;
           }
        }
        return ans;
    }
}