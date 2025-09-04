class Solution {
    public int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return dfs(nums, 0, dp);
    }

    public int dfs(int[] nums, int idx, Integer[] dp) {
        if (idx >= nums.length - 1)
            return 0;
        if (dp[idx] != null)
            return dp[idx];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[idx]; i++) {
            int jumps = dfs(nums, idx + i, dp);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, jumps+1);
            }
        }

        return dp[idx] = min;
    }
}
