class Solution {
    class Node{
        Node children[];
        boolean flag = false;
        String word="";
        Node()
        {
            children = new Node[26];
            
        }
    }
    public Node root = new Node();
    public void insert(String words[])
    {
         for(int i=0;i<words.length;i++)
         {
            String s = words[i];
            Node temp = root;
            for(int j=0;j<s.length();j++)
            {
                int idx = s.charAt(j)-'a';
                if(temp.children[idx] == null)
                {
                    temp.children[idx] = new Node();
                }
                temp = temp.children[idx];
            }
            temp.flag = true;
            temp.word = s;
         }
    }
    public List<String> list = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
         insert(words);
         Node temp = root;
         int n = board.length;
         int m = board[0].length;
         boolean[][] visited = new boolean[n][m];
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<m;j++)
            {
               dfs(i,j,temp,board,visited);
            }
         }
         return list;
    }
    public void dfs(int i, int j, Node node, char[][] board, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
            return;

        char ch = board[i][j];
        int idx = ch - 'a';

        if (node.children[idx] == null)
            return;

        node = node.children[idx];

        if (node.flag) {
            list.add(node.word);
            node.flag = false;  
        }
        visited[i][j] = true;
        dfs(i + 1, j, node, board, visited);
        dfs(i - 1, j, node, board, visited);
        dfs(i, j + 1, node, board, visited);
        dfs(i, j - 1, node, board, visited);
        visited[i][j] = false;
    }
}
