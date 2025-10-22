class Solution {
    public List<Integer> majorityElement(int[] arr) 
    {
        int n=arr.length;
        int nums1=Integer.MAX_VALUE;
        int nums2=Integer.MAX_VALUE;
        int count1=0,count2=0;
        for(int i=0;i<n;i++)
        {
            if(nums1==arr[i])
            {
                count1++;
            }
            else if(nums2==arr[i])
            {
                count2++;
            }
            else if(count1==0)
            {
                nums1=arr[i];
                count1=1;
            }
            else if(count2==0)
            {
                nums2=arr[i];
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }   
        int check1=0,check2=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]==nums1)
            {
                check1++;
            }
            else  if(arr[i]==nums2)
            {
                check2++;
            }
        }
            if(check1>n/3)
            {
                list.add(nums1);
            }
            if(check2>n/3)
            {
                list.add(nums2);
            }
        
        return list;
    }
}