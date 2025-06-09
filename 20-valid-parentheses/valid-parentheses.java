class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else
            {
                if(c == ')')
                {
                    if(st.size() == 0) return false;
                    int top = st.pop();
                    if(top != '(') return false;
                   
                }
                else if(c == ']')
                {
                    if(st.size() == 0) return false;
                    int top = st.pop();
                    if(top != '[') return false;
                }
                 else
                {
                    if(st.size() == 0) return false;
                    int top = st.pop();
                    if(top != '{') return false;
                }
            }
        }
        if(st.size() != 0)return false;
        return true;
    }
}