class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int coulIdx = -1, leftIdx = -1, rightIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                coulIdx = i;
            }

            if (nums[i] == minK) {
                leftIdx = i;
            }

            if (nums[i] == maxK) {
                rightIdx = i;
            }

            res += Math.max(0, Math.min(leftIdx, rightIdx) - coulIdx);
        }

        return res;
    }
}