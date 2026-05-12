class Solution {
    public void nextPermutation(int[] nums) 
    {
        int n=nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        {
            rev(nums,0,n);
        }
        else
        {
            for(int i=n-1;i>=0;i--)
            {
                 if(nums[i]>nums[index])
                 {
                    int t=nums[i];
                    nums[i]=nums[index];
                    nums[index]=t;
                    break;
                 }
            }
            rev(nums,index+1,n);
        }

        
    }
    public void rev(int[] nums,int j,int n)
    {
        int k=n-1;
        while(j<k)
        {
            int t=nums[j];
            nums[j]=nums[k];
            nums[k]=t;
            j++;
            k--;
        }
    }
}