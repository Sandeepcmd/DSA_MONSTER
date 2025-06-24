class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> que = new LinkedList<>(); 
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] ==2)que.offer(new int[]{i,j,0});
                if(grid[i][j] == 1)count++;
            }
        }
        if(que.size() == 0 && count == 0)return 0;
        while(que.size() > 0){
            int curr[] = que.remove();
            int i = curr[0];
            int j = curr[1];
            int t = curr[2];
            min = Math.max(min,t);
            int drow[] = {1,0,-1,0};
            int dcol[] = {0,-1,0,1};
            for(int k=0;k<4;k++)
            {
                int nrow = i+drow[k];
                int ncol = j+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == 1)
                {
                    grid[nrow][ncol] = 2;
                    que.offer(new int[]{nrow,ncol,t+1});
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)return  -1;
            }
        }
        return min;

    }
}