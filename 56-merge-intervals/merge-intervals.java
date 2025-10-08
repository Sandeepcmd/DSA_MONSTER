import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int pf = intervals[0][0];
        int ps = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int cf = intervals[i][0];
            int cs = intervals[i][1];

            if (cf <= ps) {
                ps = Math.max(ps, cs);
            } else {
                result.add(new int[]{pf, ps});
                pf = cf;
                ps = cs;
            }
        }
        result.add(new int[]{pf, ps});

        return result.toArray(new int[result.size()][]);
    }
}