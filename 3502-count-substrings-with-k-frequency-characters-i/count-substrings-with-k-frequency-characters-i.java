class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int map[] = new int[26];
        int ans = 0;
        while(j < n){
            char c = s.charAt(j);
            map[c-'a']++;
            while(check(map,k)){
                ans += n-j;
                 map[s.charAt(i)-'a']--;
                 i++;
            }
            j++;
        }
        return ans;
    }
    public boolean check(int map[],int k){
        for(int i=0;i<26;i++)
        {
            if(map[i] >= k)return true;
        }
        return false;
    }
}