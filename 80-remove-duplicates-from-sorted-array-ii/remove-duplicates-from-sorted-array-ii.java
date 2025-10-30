class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for(int i=0;i<n;i++)
        {
            if(j >= 2 && nums[i] == nums[j-2])
            {
                continue;
            }
            else
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}