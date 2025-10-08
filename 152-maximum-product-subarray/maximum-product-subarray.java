class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
             pre = pre*nums[i];
              max = Math.max(max,pre);
            if(pre == 0)
            {
               
                pre = 1;
            }    
           
        }
        for(int i=n-1;i>=0;i--)
        {
            suff = suff*nums[i];
            max = Math.max(max,suff);
            if(suff == 0)
            {
                suff = 1;
            }
        }
        return max;
    }
}