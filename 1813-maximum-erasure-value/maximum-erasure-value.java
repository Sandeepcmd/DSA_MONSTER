class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int curr = 0;
        int max = Integer.MIN_VALUE;
        while(r < n)
        {
            curr += nums[r];
            while(map.containsKey(nums[r]))
            {
                map.remove(nums[l]);
                curr -= nums[l];
                l++;
            }
            map.put(nums[r],r);
            max = Math.max(max,curr);
            r++;
        }
        return max;
    }
}