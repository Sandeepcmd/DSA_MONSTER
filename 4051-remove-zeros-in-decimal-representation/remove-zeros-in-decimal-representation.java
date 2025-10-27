class Solution 
{
    public long removeZeros(long n) 
    {
        String s =String.valueOf(n);
        String res="";

        for (int i=0;i<s.length();i++) 
        {
            char ch=s.charAt(i);
            if (ch!='0')  res=res+ch;
        }
        return Long.parseLong(res);
    }
}