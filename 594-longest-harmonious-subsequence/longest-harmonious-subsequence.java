class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l = 0, ans = 0;

        for (int h = 0; h < nums.length; h++) {
            while (nums[h] - nums[l] > 1) {
                l++;
            }
            if (nums[h] - nums[l] == 1) {
                ans = Math.max(ans, h - l + 1);
            }
        }

        return ans;
    }
}
