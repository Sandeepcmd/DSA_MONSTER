class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        help(candidates,0,target,new ArrayList<>(),n);
        return list;
    }
    public void help(int[] candidates,int idx, int target,List<Integer> temp,int n)
    {
        if(target == 0)
        {
             list.add(new ArrayList<>(temp));
             return;
        }
        for(int i=idx;i<n;i++)
        {
             if(i>idx && candidates[i] == candidates[i-1])
             {
                 continue;
             }
             if (candidates[i] > target) break;

            temp.add(candidates[i]);
            help(candidates,i+1,target-candidates[i],temp,n);
            temp.remove(temp.size()-1);
        
        }
    }
}