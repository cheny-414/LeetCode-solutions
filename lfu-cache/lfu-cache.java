class LFUCache {
    Map<Integer, Pair<Integer, Integer>> cache; //key, (freq and value) pair
    Map<Integer, HashSet<Integer>> freqs;  //freq, (list of keys) with that freq
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
        keys.remove(key);                   //remove key from hashset
        if (keys.isEmpty()) {
            freqs.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        insert(key, freq + 1, value);       //re-insert key to hashset, with freq + 1
        return value;
    }
    
    public void put(int key, int value) {
        //if (capacity <= 0) return;
        if (cache.containsKey(key)) {                                   //if key exists in cache
            cache.put(key, new Pair<>(cache.get(key).getKey(), value)); //update cache with new value
            get(key);                                                   //perform get = remove + re-insert (freq + 1)
            return;
        }

        if (capacity == cache.size()) {                                 //if capacity reached before adding this new key
            Set<Integer> keys = freqs.get(minFreq);                     //find keys with min frequency
            int keyToDelete = keys.iterator().next();                   //find first key in that set
            cache.remove(keyToDelete);                                  //delete key from cache
            keys.remove(keyToDelete);                                   //delete key from set
            if (keys.isEmpty()) {                                       //min freq list is empty, delete this freq from map
                freqs.remove(minFreq);
            }
        }

        minFreq = 1;                                                    //added a brand new key, min freq is now 1
        insert(key, 1, value);                                          //insert this new key
    }

    private void insert(int key, int freq, int value) {
        cache.put(key, new Pair<>(freq, value));                        //add key, freq, value to cache
        freqs.putIfAbsent(freq, new LinkedHashSet<>());
        freqs.get(freq).add(key);                                       //add key to freq map 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */