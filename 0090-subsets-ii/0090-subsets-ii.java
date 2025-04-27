class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,list,new ArrayList<>());
        return list;
    }
    public void solve(int i,int nums[],List<List<Integer>> list,List<Integer> temp)
    {
        if(i>=nums.length)
        {
             list.add(new ArrayList<>(temp));
             return ;
        }
            temp.add(nums[i]);
            solve(i+1,nums,list,temp);
            temp.remove(temp.size()-1);
            while(i<nums.length-1 && nums[i] == nums[i+1])
            {
                i++;
            }
            solve(i+1,nums,list,temp);
       
    }
}