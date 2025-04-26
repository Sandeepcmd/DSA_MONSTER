class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        TreeMap<String, Integer> map = new TreeMap<>();

        for (List<String> responseList : responses) {
            Set<String> tempSet = new HashSet<>(responseList); 
            for (String ele : tempSet) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }
        }

        int max = 0;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }
}
