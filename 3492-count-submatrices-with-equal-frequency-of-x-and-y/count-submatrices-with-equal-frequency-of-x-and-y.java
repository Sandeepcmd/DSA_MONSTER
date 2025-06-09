class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dup1[][] = new int[n][m];
        int dup2[][] = new int[n][m];
        int pre1[][] = new int[n][m];
        int pre2[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 'X')
                {
                    dup1[i][j] = 1;
                }
                else
                {
                    dup1[i][j] = 0;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 'Y')
                {
                    dup2[i][j] = 1;
                }
                else
                {
                    dup2[i][j] = 0;
                }
            }
        }
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(c == 0)
                {
                    pre1[r][c] = dup1[r][c];
                }
                else
                {
                    pre1[r][c] = dup1[r][c]+pre1[r][c-1];
                }
            }
        }
        for(int c=0;c<m;c++)
        {
            for(int r=0;r<n;r++)
            {
                if(r != 0)
                {
                    pre1[r][c] = pre1[r-1][c]+pre1[r][c];
                }
            }
        }
        for(int r=0;r<n;r++)
        {
            for(int c=0;c<m;c++)
            {
                if(c == 0)
                {
                    pre2[r][c] = dup2[r][c];
                }
                else
                {
                    pre2[r][c] = dup2[r][c]+pre2[r][c-1];
                }
            }
        }
        for(int c=0;c<m;c++)
        {
            for(int r=0;r<n;r++)
            {
                if(r != 0)
                {
                    pre2[r][c] = pre2[r-1][c]+pre2[r][c];
                }
            }
        }
        int c = 0; 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pre1[i][j] == pre2[i][j] && pre1[i][j] != 0)
                {
                    c++;
                }
            }
        }
        return c;
    }
}