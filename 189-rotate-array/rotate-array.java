class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        int j = 0;
        int d = k%n;
        for(int i=n-d;i<n;i++)
        {
            ans[j++] = nums[i];
        }
        for(int i=0;i<n-d;i++)
        {
            ans[j++] = nums[i];
        }
        for(int i=0;i<n;i++)
        {
           nums[i] = ans[i];
        }
        
    }
}