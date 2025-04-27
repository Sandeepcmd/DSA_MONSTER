class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solve(candidates,target,0,list,new ArrayList<>());
        return list;
    }
    public void solve(int candidates[],int target,int i,List<List<Integer>> list,List<Integer> temp)
    {
        if(target < 0)
        {
            return;
        }
        if(target == 0)
        {
             list.add(new ArrayList<>(temp));
             return;
        }
        if(i >= candidates.length)
        {
            return ;
        }
        temp.add(candidates[i]);
        solve(candidates,target-candidates[i],i,list,temp);
        temp.remove(temp.size()-1);
        solve(candidates,target,i+1,list,temp);

    }
}