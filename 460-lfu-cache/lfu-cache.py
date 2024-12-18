class LFUCache:

    def __init__(self, capacity: int):
        self.cache = {} # key: freq, value
        self.freqs = {} # freq: list of (keys: None)
        self.capacity = capacity
        self.min_freq = 0

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        freq, value = self.cache[key]
        del self.freqs[freq][key]
        if not self.freqs[freq]:
            del self.freqs[freq]
            if freq == self.min_freq:
                self.min_freq = freq + 1
        self.insert(key, value, freq + 1)
        return value
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = (self.cache[key][0], value)
            self.get(key)
            return
        if self.capacity == len(self.cache):
            keysToRemove = self.freqs[self.min_freq]
            keyToRemove = next(iter(keysToRemove.keys()))
            del self.cache[keyToRemove]
            del self.freqs[self.min_freq][keyToRemove]
            if not self.freqs[self.min_freq]:
                del self.freqs[self.min_freq]
        self.min_freq = 1
        self.insert(key, value, 1)
    def insert(self, key, value, freq):
        self.cache[key] = (freq, value)
        if freq not in self.freqs:
            self.freqs[freq] = defaultdict()
        self.freqs[freq][key] = None


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)