class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayDivide(nums, 0, nums.length - 1);
    }

    private int maxSubArrayDivide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftMax = maxSubArrayDivide(nums, left, mid);
        int rightMax = maxSubArrayDivide(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) leftSum = sum;
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) rightSum = sum;
        }
        return leftSum + rightSum;
    }
}
