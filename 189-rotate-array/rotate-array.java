class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        help(nums,0,n-1);
        help(nums,0,k-1);
        help(nums,k,n-1);
    }
    public void help(int nums[],int i,int j)
    {
        while(i <= j)
        {
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
           i++;
           j--;
        }
    }
}