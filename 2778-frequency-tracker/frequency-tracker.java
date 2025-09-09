class FrequencyTracker {
    public HashMap<Integer,Integer> map1;
    public HashMap<Integer,Integer> map2;

    public FrequencyTracker() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void add(int number) {
        int oldFreq = map1.getOrDefault(number, 0);
        int newFreq = oldFreq + 1;
        map1.put(number, newFreq);
        if (oldFreq > 0) {
            map2.put(oldFreq, map2.get(oldFreq) - 1);
            if (map2.get(oldFreq) == 0) map2.remove(oldFreq);
        }
        map2.put(newFreq, map2.getOrDefault(newFreq, 0) + 1);
    }

    public void deleteOne(int number) {
        if (!map1.containsKey(number)) return;
        int oldFreq = map1.get(number);
        int newFreq = oldFreq - 1;
        if (newFreq == 0) map1.remove(number);
        else map1.put(number, newFreq);
        map2.put(oldFreq, map2.get(oldFreq) - 1);
        if (map2.get(oldFreq) == 0) map2.remove(oldFreq);
        if (newFreq > 0) map2.put(newFreq, map2.getOrDefault(newFreq, 0) + 1);
    }

    public boolean hasFrequency(int frequency) {
        return map2.containsKey(frequency) && map2.get(frequency) > 0;
    }
}
