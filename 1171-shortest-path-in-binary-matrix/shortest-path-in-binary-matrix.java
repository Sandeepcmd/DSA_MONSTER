class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        int dist[][] = new int[n][m];
        for(int d[] : dist)Arrays.fill(d,Integer.MAX_VALUE);
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,1});
        dist[0][0] = 1;
        int min =Integer.MAX_VALUE;
        int drow[] = {-1,0,1,0,-1,1,-1,1};
        int dcol[] = {0,-1,0,1,-1,1,1,-1};
        while(pq.size() > 0)
        {
            int curr[] = pq.poll();
            int i = curr[0];
            int j = curr[1];
            if(i == n-1 && j ==m-1)min = Math.min(min,dist[i][j]);
            int d = curr[2];
            for(int k=0;k<8;k++)
            {
                int nrow = i+drow[k];
                int ncol = j+dcol[k];
                if(nrow>=0 && ncol >=0 && nrow <n && ncol < m && grid[nrow][ncol] == 0 && dist[i][j] + 1 < dist[nrow][ncol])
                {
                    dist[nrow][ncol] = dist[i][j] + 1;
                    pq.offer(new int[]{nrow,ncol,dist[nrow][ncol]});
                }
            }
        }
        return (min == Integer.MAX_VALUE)?-1:min;
    }
}