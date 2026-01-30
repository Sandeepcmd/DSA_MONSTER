class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = ans*nums[i];
            max = Math.max(ans,max);
            if(ans == 0)ans = 1;
        }
        ans = 1;
        for(int i=n-1;i>=0;i--){
            ans = ans*nums[i];
            max = Math.max(ans,max);
            if(ans == 0)ans = 1;
        }
        return max;
    }
}