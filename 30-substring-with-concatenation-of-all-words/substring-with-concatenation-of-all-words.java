class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;

        int check = words[0].length(); 
        int len = check * words.length;

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < check; i++) {
            int j = i;
            int start = i;
            HashMap<String, Integer> tempMap = new HashMap<>();
            int count = 0;

            while (j + check <= s.length()) {
                String s1 = s.substring(j, j + check);

                if (map.containsKey(s1)) {
                    tempMap.put(s1, tempMap.getOrDefault(s1, 0) + 1);
                    count++;

                    while (tempMap.get(s1) > map.get(s1)) {
                        String rem = s.substring(start, start + check);
                        tempMap.put(rem, tempMap.get(rem) - 1);
                        count--;
                        start += check;
                    }

                    if (count == words.length) {
                        list.add(start);
                        String rem = s.substring(start, start + check);
                        tempMap.put(rem, tempMap.get(rem) - 1);
                        count--;
                        start += check;
                    }
                } else {
                    tempMap.clear();
                    count = 0;
                    start = j + check;
                }

                j += check;
            }
        }

        return list;
    }
}