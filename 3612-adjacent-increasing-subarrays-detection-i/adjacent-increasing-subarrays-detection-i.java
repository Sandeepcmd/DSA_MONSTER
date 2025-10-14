class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int i = 0;
        int j = 2*k-1;
        while(j < n)
        {
           int l = i+k;
           int i1 = i;
           int c1 = 1;
           int c2 = 1;
           while(i1 < l-1)
           {
             if(nums.get(i1) < nums.get(i1+1))c1++;
             i1++;
           }
           while(l<j)
           {
              if(nums.get(l) < nums.get(l+1))c2++;
              l++;
           }
           if(c1+c2 == 2*k)return true;
           i++;
           j++;
        }
        return false;
    }
}