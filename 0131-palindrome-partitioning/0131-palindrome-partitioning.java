class Solution {
    public List<List<String>> partition(String s) 
    {
       List<List<String>> list=new ArrayList<>();
       List<String> temp=new ArrayList<>();
       Palindrome(list,temp,0,s); 
       return list;  
    }
     public void Palindrome( List<List<String>> list,List<String> temp,int idx,String s) 
     {
        int n=s.length();
          if(idx==n)
          {
              list.add(new ArrayList<>(temp));
              return;
              
          }
          for(int j=idx;j<n;j++)
          {
            String newString=s.substring(idx,j+1);
            if(func(newString))
            {
                temp.add(newString);
                Palindrome(list,temp,j+1,s);
                temp.remove(temp.size()-1);
            }
          }
     }
     public boolean func(String s1)
     {
        int i=0,j=s1.length()-1;
        while(i<j)
        {
            if(s1.charAt(i++)!=s1.charAt(j--))
            {
                return false;
            }
        }
        return true;
     }
    

}