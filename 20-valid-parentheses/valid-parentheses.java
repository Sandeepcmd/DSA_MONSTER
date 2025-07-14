class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c == '('||c == '{' || c == '['){
                st.push(c);
            }
            else
            {  if(st.size() == 0)return false;
                if(c == ')')
                {
                   if(st.peek() != '(')return false;
                   st.pop();
                }
                if(c == ']')
                {
                    if(st.peek() != '[')return false;
                   st.pop();
                }
                if(c == '}')
                {
                     if(st.peek() != '{')return false;
                   st.pop();
                }
            }
        }
        return (st.size()==0)?true:false;
    }
}