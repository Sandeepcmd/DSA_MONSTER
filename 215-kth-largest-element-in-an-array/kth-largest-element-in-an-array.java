class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
        }
        while(k!=0)
        {
            ans=pq.peek();
            pq.remove();
            k--;
        }
        return ans;
        
    }
}