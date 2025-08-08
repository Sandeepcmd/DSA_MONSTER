class Solution {
    public String frequencySort(String s) {
        int[] map = new int[128]; 
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, (a, b) -> {
            if (map[b] != map[a]) return map[b] - map[a];
            return a - b;
        });

        StringBuilder ob = new StringBuilder();
        for (char c : chars) ob.append(c);

        return ob.toString();
    }
}
