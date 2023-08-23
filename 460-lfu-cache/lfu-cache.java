class LFUCache {
    Map<Integer, Pair<Integer, Integer>> cache; //key, (value, frequency) pair
    Map<Integer, LinkedHashSet<Integer>> freqs; //frequency, set of keys with same frequency
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqs = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        //if key doesn't exist, return -1
        if (!cache.containsKey(key)) return -1;

        //get value, frequency
        int value = cache.get(key).getKey();
        int freq = cache.get(key).getValue();

        //update freq + 1

        //remove key from currrent freqs
        Set<Integer> keys = freqs.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqs.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }

        //add back with +1 freq
        insert(key, value, freq + 1);
        return value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            int freq = cache.get(key).getValue();
            get(key);
            cache.put(key, new Pair<>(value, freq + 1));
            return;
        }

        //new entry, remove least frequently used
        if (capacity == cache.size()) {
            Set<Integer> minKeys = freqs.get(minFreq);
            int toRemove = minKeys.iterator().next();
            minKeys.remove(toRemove);
            cache.remove(toRemove);
            if (minKeys.isEmpty()) {
                freqs.remove(minFreq);
            }
        }

        minFreq = 1;
        insert(key, value, 1);
    }

    private void insert(int key, int value, int freq) {
        freqs.putIfAbsent(freq, new LinkedHashSet<>());
        freqs.get(freq).add(key);
        cache.put(key, new Pair<>(value, freq));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */