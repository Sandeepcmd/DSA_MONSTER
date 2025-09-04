class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;
        if(n == 1)return 0;
        int i = 0;
        int j = 1;
        int ans = 0;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        while(j<n){
            int cf = arr[i][0];
            int cs = arr[i][1];
            int nf = arr[j][0];
            int ns = arr[j][1];
            if(cs > nf){
                if(cs <= ns){
                    j++;
                    ans++;
                }
                else{
                    i = j;
                    ans++;
                    j++;
                }
            }
            else{
                i = j;
                j++;
            }
        }
        return ans;
    }
}