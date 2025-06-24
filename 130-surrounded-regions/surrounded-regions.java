class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visit[][] = new boolean[n][m]; 
        Queue<int []> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1 )&&(board[i][j] == 'O') ){
                    que.offer(new int[]{i,j});
                    visit[i][j] = true;
                }
            }
        }
        int drow[] = {1,0,-1,0};
        int dcol[] = {0,1,0,-1};
        while(que.size() > 0)
        {
             int curr[] = que.remove();
             int i = curr[0];
             int j = curr[1];
             for(int k=0;k<4;k++){
                int nrow = i+drow[k];
                int ncol = j+dcol[k];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && board[nrow][ncol] == 'O' && !visit[nrow][ncol])
                {
                    visit[nrow][ncol] = true;
                    que.offer(new int[]{nrow,ncol});
                }
             }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(board[i][j] == 'O' && !visit[i][j]){
                      board[i][j] = 'X';
                }
            }
        }

    }
}