class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        help(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void help(List<String> list, StringBuilder sb, int open, int close, int n) {
        if (open < close) return;  
        if (open > n || close > n) return;
        if (open == n && close == n) { 
            list.add(sb.toString());
            return;
        }

        sb.append('(');
        help(list, sb, open + 1, close, n);
        sb.deleteCharAt(sb.length() - 1); 
        sb.append(')');
        help(list, sb, open, close + 1, n);
        sb.deleteCharAt(sb.length() - 1); 
    }
}
