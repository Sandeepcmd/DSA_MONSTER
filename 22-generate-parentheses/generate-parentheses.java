class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        solve("",n,0,0);
        return list;
    }
    public void solve(String s,int n,int open,int close)
    {
        if(open > n || close > open)return;
        if(open + close == 2*n){
            list.add(s);
            return;
        }
        solve(s+"(",n,open+1,close);
        solve(s+")",n,open,close+1);
    }
}