class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(k == 1)return 0;
        int min = Integer.MAX_VALUE;
        int  i = 0,j = 0;
        while(j < n)
        {
            if(j-i+1 < k)
            {
                j++;
            }
            else{
                 int diff = nums[j]-nums[i];
                 min = Math.min(min,diff);
                 i++;
            }
        }
        return min;
       
    }
}