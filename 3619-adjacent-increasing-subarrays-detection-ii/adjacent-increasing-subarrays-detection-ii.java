class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        int[] pre = new int[n];
        pre[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            pre[i] = (nums.get(i) < nums.get(i + 1)) ? pre[i + 1] + 1 : 1;
        }

        int l = 1, h = n / 2, ans = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (check(mid, pre)) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int k, int[] pre) {
        int n = pre.length;
        for (int i = 0; i + k < n; i++) {
            if (pre[i] >= k && pre[i + k] >= k) return true;
        }
        return false;
    }
}
