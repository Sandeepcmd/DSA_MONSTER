class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int c = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        if(c != color)
        {
            image[sr][sc] = color;
        }
        boolean visited[][] = new boolean[n][m];
        visited[sr][sc] = true;
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[]{sr,sc});
        int drow[] = {1,0,-1,0};
        int dcol[] = {0,-1,0,1};
        while(que.size() > 0)
        {
            int curr[] = que.remove();
            int i = curr[0];
            int j = curr[1];
            for(int k=0;k<4;k++)
            {
                int nrow = i+drow[k];
                int ncol = j+dcol[k];
                if(nrow >= 0 && nrow<n && ncol >= 0 && ncol <m && image[nrow][ncol] == c && !visited[nrow][ncol])
                {
                    visited[nrow][ncol] = true;
                    image[nrow][ncol] = color;
                    que.offer(new int[]{nrow,ncol}); 
                }
            }
        }
        return image;
    }
}