class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int g[] = new int[m+1];
        Stack<Integer> st = new Stack<>();
        st.push(nums2[m-1]);
        g[m-1] = -1;
        for(int i=m-2;i>=0;i--)
        {
           while(st.size() > 0 && st.peek() < nums2[i])
           {
            st.pop();
           }
           if(st.size() == 0)
           {
            g[i] = -1;
           }else
           {
            g[i] = st.peek();
           }
           st.push(nums2[i]);
        }
        int ans[] = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++)map.put(nums2[i],i);
        for(int i=0;i<n;i++)
        {
            ans[i] = g[map.get(nums1[i])];
        }
        return ans;
    }
}