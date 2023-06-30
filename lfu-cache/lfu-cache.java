class LFUCache {
    Map<Integer, Pair<Integer, Integer>> cache; //key, (freq and value) pair
    Map<Integer, LinkedHashSet<Integer>> freqs;  //freq, (list of keys) with that freq
    int minFreq;
    int capacity;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqs = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        int freq = cache.get(key).getKey();
        int value = cache.get(key).getValue();
        Set<Integer> keys = freqs.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqs.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        insert(key, freq + 1, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cache.containsKey(key)) {
            cache.put(key, new Pair<>(cache.get(key).getKey(), value));
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            Set<Integer> keys = freqs.get(minFreq);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                freqs.remove(minFreq);
            }
        }

        minFreq = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int freq, int value) {
        cache.put(key, new Pair<>(freq, value));
        freqs.putIfAbsent(freq, new LinkedHashSet<>());
        freqs.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */