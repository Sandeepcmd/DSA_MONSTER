class Solution {
    class Pair
    {
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalcolor = image[sr][sc];
        if(originalcolor == color)
        {
            return image;
        }
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(sr,sc));
        image[sr][sc] = color;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(que.size() > 0)
        {
            Pair curr = que.remove();
            int i = curr.first;
            int j = curr.second;
            for(int k=0;k<4;k++)
            {
                int ni = i+drow[k];
                int nj = j+dcol[k];
                if(ni>=0 && ni<n && nj>=0 && nj<m && image[ni][nj] == originalcolor)
                {
                    image[ni][nj] = color;
                    que.offer(new Pair(ni,nj));
                }
            }
        }
        return image;
    }
}