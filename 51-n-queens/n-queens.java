class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        nQueens(board, ans, n, 0);
        return ans;
    }
    public static void nQueens(char[][] board, List<List<String>> ans, int n, int col){
        if(col == n){
            ans.add(constructBoard(board));
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(board,row, col)){
                board[row][col] = 'Q';
                nQueens(board,ans,n,col+1); 
                board[row][col] = '.'; 
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        int i= row;
        int j= col;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = i;
        col = j;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = i;
        col = j;
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public static List<String> constructBoard(char[][] board) {
    List<String> result = new ArrayList<>();
    for (char[] row : board) {
        result.add(new String(row));
    }
    return result;
}

    
}