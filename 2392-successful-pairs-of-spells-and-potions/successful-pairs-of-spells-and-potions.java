class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        int n=spells.length;
        int m=potions.length;
        Arrays.sort(potions);
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int ele=spells[i];
            int low=0,high=m-1;
            int size=0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((long) potions[mid] * ele >= success) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            
            size = m - low;
            ans[i] = size;
        }
        return ans;
    }
}