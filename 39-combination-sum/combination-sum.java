class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(0,list,temp,arr,target);
        return list;
    }
    public void help(int idx,List<List<Integer>>list,List<Integer> temp,int arr[],int target)
    {
        if(target < 0)return;
        if(target == 0)
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            if(i>idx && arr[i] == arr[i-1])continue;
            temp.add(arr[i]);
            help(i,list,temp,arr,target-arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}