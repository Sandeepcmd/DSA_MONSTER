class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int n=arr.length;
        int ans[]=new int[n];
        
        Stack<Integer> st =new Stack<>();
        st.add(-1);
        for(int i=n-1;i>=0;i--)
        {
            ans[i]=st.peek();
            if(arr[i]>st.peek())
            {
                st.pop();
                st.add(arr[i]);
            }
        }
        return ans;


        
    }
}