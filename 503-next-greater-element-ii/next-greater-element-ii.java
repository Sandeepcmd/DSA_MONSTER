class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=2*n-1;i>=0;i--)
        {
            int idx = i%n;
            while(st.size() != 0 && nums[idx] >= st.peek())
            {
                st.pop();
            }
            if(st.size() == 0)
            {
                if(i < n)arr[i] = -1;
            }
            else
            {
                if(i<n) arr[i] = st.peek();
            }
            st.push(nums[idx]);
        }
        return arr;
    }
}