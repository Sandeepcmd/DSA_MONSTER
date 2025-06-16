import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007L;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long count = 0;
        for (int j = 1; j < n - 1; j++) {
            int ele = nums[j] * 2;
            List<Integer> list = map.get(ele);
            if (list == null) continue;

            int idx = lowerBound(list, j);
            long freqPrev = idx;
            long freqNext = list.size() - idx;
            if (idx < list.size() && list.get(idx) == j) freqNext--;

            count = (count + (freqPrev * freqNext) % mod) % mod;
        }
        return (int) count;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
