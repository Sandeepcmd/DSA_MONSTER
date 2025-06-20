class Solution {
    public void solve(char[][] board) 
    {
        int n=board.length;
        int m=board[0].length;
        boolean visit[][]=new boolean[n][m];
        Queue<int []> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i == 0 || j == 0 || i == n-1 || j == m-1) {
                    if(board[i][j] == 'O') {
                        que.add(new int[]{i,j}); 
                        visit[i][j] = true; 
                    }
                }
            }
        }
        int drow[]={1,0,-1,0};
        int dcol[]={0,-1,0,1};
        while(!que.isEmpty())
        {
            int curr[]=que.remove();
            for(int i=0;i<4;i++)
            {
                int x=curr[0]+drow[i];
                int y=curr[1]+dcol[i];
                if(x>=0 && x<n && y>=0 && y<m && visit[x][y]!=true && board[x][y]=='O')
                {
                    que.offer(new int[]{x,y});
                    visit[x][y]=true;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && visit[i][j]!=true)
                {
                    board[i][j]='X';
                }
            }
        }
    }
}