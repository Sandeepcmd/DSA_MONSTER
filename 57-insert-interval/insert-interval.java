import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        while (i < n && intervals[i][1] < newStart) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);
            i++;
        }
        result.add(new int[]{newStart, newEnd});
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
