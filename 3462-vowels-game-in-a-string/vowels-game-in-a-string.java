class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        while(i < n)
        {
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' ||  c == 'u'){
                count++;
            }
            i++;
        }
        if(count == 0)return false;
        return true;
    }
}