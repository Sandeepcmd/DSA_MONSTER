class Solution {
    public List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        int n = digits.length();
        solve(map,0,n,"",digits);
        return list;
    }
    public void solve(HashMap<Character,String> map,int i,int n,String s,String digits)
    {
        if(i == n){
            list.add(s);
            return;
        }
        char c = digits.charAt(i);
        String m = map.get(c);
        for(int j = 0;j<m.length();j++)
        {
            char c1 = m.charAt(j);
            solve(map,i+1,n,s+c1,digits);
        }
    }

}