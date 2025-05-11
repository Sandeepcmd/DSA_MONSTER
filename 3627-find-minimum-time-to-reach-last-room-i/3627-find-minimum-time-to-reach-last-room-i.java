class Solution {
    class Tuple {
        int first, second, third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minTime = new int[n][m];
        for (int[] row : minTime) 
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.third - t2.third);
        pq.offer(new Tuple(0, 0, 0));
        minTime[0][0] = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int i = curr.first;
            int j = curr.second;
            int t = curr.third;
             
            if (i == n - 1 && j == m - 1) {
                return t;
            }
            for (int k = 0; k < 4; k++) {
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                   int waitTime = t < moveTime[nrow][ncol] ? moveTime[nrow][ncol] : t;
                   int nt = waitTime + 1;
                   
                    if (nt < minTime[nrow][ncol]) {
                        minTime[nrow][ncol] = nt;
                        pq.offer(new Tuple(nrow, ncol, nt));
                    }
                }
            }
        }

        return -1; 
    }
}
