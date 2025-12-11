import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // Map: row -> set of columns that have buildings (sorted)
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        // Map: col -> set of rows that have buildings (sorted)
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();
        
        for (int[] b : buildings) {
            int r = b[0];
            int c = b[1];
            rowMap.computeIfAbsent(r, k -> new TreeSet<>()).add(c);
            colMap.computeIfAbsent(c, k -> new TreeSet<>()).add(r);
        }
        
        int covered = 0;
        for (int[] b : buildings) {
            int r = b[0];
            int c = b[1];
            
            TreeSet<Integer> cols = rowMap.get(r);
            TreeSet<Integer> rows = colMap.get(c);
            if (cols == null || rows == null) continue; // safety (shouldn't happen)
            
            Integer left = cols.lower(c);
            Integer right = cols.higher(c);
            Integer up = rows.lower(r);
            Integer down = rows.higher(r);
            
            if (left != null && right != null && up != null && down != null) {
                covered++;
            }
        }
        
        return covered;
    }
}
