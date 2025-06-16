import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long ans = 0;
        for (int j = 1; j < n - 1; j++) {
            int target = nums[j] * 2;
            List<Integer> pos = idxMap.get(target);
            if (pos == null) continue;

            int lb = lowerBound(pos, j);
            long left = lb;
            long right = pos.size() - lb;
            if (lb < pos.size() && pos.get(lb) == j) right--;

            ans = (ans + (left * right) % MOD) % MOD;
        }

        return (int) ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
