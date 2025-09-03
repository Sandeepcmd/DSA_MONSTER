class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que = new LinkedList<>(); 
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int j = 0; j < n; j++) {
           
            while (!que.isEmpty() && que.peekFirst() <= j - k) {
                que.removeFirst();
            }
            while (!que.isEmpty() && nums[que.peekLast()] < nums[j]) {
                que.removeLast();
            }
            que.offer(j);
            if (j >= k - 1) {
                list.add(nums[que.peekFirst()]);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
