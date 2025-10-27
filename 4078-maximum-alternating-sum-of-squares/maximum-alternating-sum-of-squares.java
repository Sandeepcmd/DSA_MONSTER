class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long minSum = 0;
        long maxSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums)
        {
            pq.offer(Math.abs(i));
        }
        long min = n/2;
        while(min-- > 0 && pq.size() > 0)
        {
            int ele = pq.remove();
            minSum += (long)(ele*ele);
        }
        while(pq.size() > 0)
        {
            int ele = pq.remove();
            maxSum += (long)(ele*ele);
        }
        return  maxSum - minSum;
    }
}