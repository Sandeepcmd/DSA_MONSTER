class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(dfs(i,j,n,m,0,board,word))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int n,int m,int k,char board[][],String word)
    {
        if(k == word.length())
        {
            return true;
        }
        if(i<0 || i>=n || j<0 || j>=m || board[i][j] != word.charAt(k))
        {
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '.';
        boolean left = dfs(i-1,j,n,m,k+1,board,word);
        boolean right = dfs(i+1,j,n,m,k+1,board,word);
        boolean up = dfs(i,j-1,n,m,k+1,board,word);
        boolean down = dfs(i,j+1,n,m,k+1,board,word);
        board[i][j] = ch;
        return left || right || up || down;
        

    }
}