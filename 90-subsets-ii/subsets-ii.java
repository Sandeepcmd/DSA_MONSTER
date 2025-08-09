class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
     List<List<Integer>> list =new ArrayList<>();
        solve(0,list,nums,new ArrayList<>());
        return list;
    }
    public void solve(int idx,List<List<Integer>> list,int nums[],List<Integer> temp)
    {
        list.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i] == nums[i-1])continue;
            temp.add(nums[i]);
            solve(i+1,list,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}