class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int last = nums2[n];
        int min = Math.abs(nums1[0] - last);
        long count = 0;

        boolean notFound = true;

        for (int i = 0; i < n; i++) {
            if (notFound && ((last <= nums2[i] && last >= nums1[i]) ||
                    (last <= nums1[i] && last >= nums2[i]))) {
                count++;
                notFound = false;
            } else {
                min = Math.min(min, Math.abs(nums1[i] - last));
                min = Math.min(min, Math.abs(nums2[i] - last));
            }
            count += Math.abs(nums1[i] - nums2[i]);
        }

        if (notFound) {
            count += min + 1;
        }

        return count;
    }
}