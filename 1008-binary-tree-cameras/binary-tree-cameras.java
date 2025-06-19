class Solution {
    private int ans = 0;
    
    public int minCameraCover(TreeNode root) {
        int a = dfs(root);
        if(a == 1)
        {
           ans++;
        }
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 1 || right == 1){
            ans++;
            return 2;  
    }

        if (left == 2 || right == 2) {
            return 0; 
        }
        return 1; 
    }
}