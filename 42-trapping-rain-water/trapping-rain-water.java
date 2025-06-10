class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int i = 0;
        int j = n-1;
        int left = height[0];
        int right = height[n-1];
        while(i < j)
        {
             if(left < right)
             {
                ans = ans+( left-height[i]);
                i++;
                left = Math.max(left,height[i]);
             }
             else
             {
                ans = ans + (right - height[j]);
                j--;
                 right = Math.max(right,height[j]);
             }
        }
        return ans;
    }
}