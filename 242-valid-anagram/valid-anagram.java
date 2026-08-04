class Solution {
    public boolean isAnagram(String s, String t) {
        int smap[] = new int[26];
        int tmap[] = new int[26];
        int n = s.length();
        int m = t.length();
        if(n != m)return false;
        for(int i=0;i<n;i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            smap[c1-'a']++;
            tmap[c2-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(smap[i] != tmap[i])return false;
        }
        return true;
    }
}