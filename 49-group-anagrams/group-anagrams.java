class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        int n = strs.length;
        for(int i=0;i<n;i++)
        {
            String s = strs[i];
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String s1 = new String(arr);
            map.computeIfAbsent(s1, k -> new ArrayList<>()).add(s);
        }
        list.addAll(map.values());
        return list;
    }
}