class FindSumPairs {
    public int arr1[];
    public int arr2[];
    public HashMap<Integer,Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        arr1 = new int[n];
        arr2 = new int[m];
        arr1 = nums1;
        arr2 = nums2;
        map = new HashMap<>();
         for(int i=0;i<arr2.length;i++)
        {
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        }
    }
    
  public void add(int index, int val) {
    int oldVal = arr2[index];
    int newVal = oldVal + val;
    map.put(oldVal, map.get(oldVal) - 1);
    if (map.get(oldVal) == 0) {
        map.remove(oldVal);
    }
    map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    arr2[index] = newVal;
}
    
    public int count(int tot) {
        int target = tot;
        int ans = 0;
        for(int i=0;i<arr1.length;i++)
        {
            int key = target-arr1[i];
            if(map.containsKey(key))
            {
                 ans+=map.get(key);
                //  map.put(key,map.get(key)-1);
                //  if(map.get(key) == 0)map.remove(key);
            }
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */