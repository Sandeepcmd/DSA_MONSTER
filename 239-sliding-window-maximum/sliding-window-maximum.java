class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int j = 0;
        int i = 0;
        while(j < n)
        {
            while(dq.size() > 0 && dq.peekLast() < nums[j])
            {
                dq.removeLast();
            }
            dq.addLast(nums[j]);
            if(j-i+1 < k)
            {
                j++;
            }
            else
            {
                list.add(dq.peekFirst());
                if(dq.peekFirst() == nums[i])
                {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            ans[l] = list.get(l);
        }
        return ans;
    }
}