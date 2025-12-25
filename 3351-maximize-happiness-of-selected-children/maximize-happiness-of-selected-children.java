class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<arr.length;i++)
        {
            pq.offer(arr[i]);
        }
        int i = 0;
        long ans = 0;
        while(pq.size() > 0 && i < k)
        {
            int ele = pq.remove()-i;

            if(ele < 0)break;
            ans = ans + (long)ele;
            i++;
        }
        return ans;
    }
}