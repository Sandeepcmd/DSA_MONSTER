class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve("",list,0,0,2*n);
        return list;
    }
    public void solve(String s,List<String> list,int open,int close,int n)
    {
        if(close > open || open > n/2 || close > n/2)return;
        if(s.length() == n)
        {
            list.add(s);
            return;
        }
        solve(s+"(",list,open+1,close,n);
        solve(s+")",list,open,close+1,n);

    }
}