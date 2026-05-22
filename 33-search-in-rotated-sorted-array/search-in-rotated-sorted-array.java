class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }
            if(nums[low] <= nums[mid]){
                if(nums[mid] >= target && nums[low] <= target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return ans;
    }
}