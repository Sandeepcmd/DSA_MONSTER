import java.util.*;

class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity[i];
        }

        long ans = 0;
        Map<Long, Map<Long, Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long val = capacity[i];
            long prefix_r = prefix[i];
            if (mp.containsKey(val) && mp.get(val).containsKey(prefix_r)) {
                ans += mp.get(val).get(prefix_r);
            }
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0) {
                ans--;
            }

            long key = prefix[i + 1] + capacity[i];
            mp.computeIfAbsent(val, k -> new HashMap<>());
            Map<Long, Integer> inner = mp.get(val);
            inner.put(key, inner.getOrDefault(key, 0) + 1);
        }

        System.out.println(ans);
        return ans;
    }
}
