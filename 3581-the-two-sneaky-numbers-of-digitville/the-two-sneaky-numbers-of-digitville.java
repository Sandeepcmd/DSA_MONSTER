class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        HashSet<Integer> set = new HashSet();int j=0;
        for(int i=0;i<n;i++) {
            if(set.contains(nums[i])) {
                ans[j++] = nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return ans;
    }
}