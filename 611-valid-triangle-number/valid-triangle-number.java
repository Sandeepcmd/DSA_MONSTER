class Solution {
    public int triangleNumber(int[] A) 
    {
       int n = A.length;
 
        Arrays.sort(A);
 
        int count = 0;
 
        for (int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }
        return count;
        
    }
}