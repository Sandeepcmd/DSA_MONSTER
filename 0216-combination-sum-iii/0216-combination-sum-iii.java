class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        solve(1,n,k,n,list,new ArrayList<>());
        return list;
    }
    public void solve(int idx,int n,int k,int target,List<List<Integer>> list,List<Integer> temp)
    {
        if(target < 0)
        {
            return;
        }
        if(target == 0 && temp.size() == k)
        {
             list.add(new ArrayList<>(temp));
             return;
        }
        for(int i=idx;i<=9;i++)
        {
             temp.add(i);
             solve(i+1,n,k,target-i,list,temp);
             temp.remove(temp.size()-1);
             
        }
    }
}