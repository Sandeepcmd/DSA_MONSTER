class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        help(s,0,list,temp);
        return list;
    }
    public void help(String s,int idx, List<List<String>> list,List<String> temp)
    {
        if(idx == s.length())
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            String s1 = s.substring(idx,i+1);
            if(check(s1))
            {
                temp.add(s1);
                help(s,i+1,list,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean check(String s1)
    {
        int i = 0;
        int j = s1.length()-1;
        while(i < j)
        {
            if(s1.charAt(i) != s1.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}