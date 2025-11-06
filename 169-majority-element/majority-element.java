class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0];
        int c = 1;
        for(int i = 1;i<n;i++)
        {
              if(nums[i] != ele)
              {
                 c--;
                 if(c == 0)
                 {
                    ele = nums[i];
                    c = 1;
                 }
              }else
              {
                c++;
              }
        }
        return ele;
    }
}