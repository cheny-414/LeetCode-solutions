class LFUCache:

    def __init__(self, capacity: int):
        self.cache = defaultdict() #key : (freq, value)
        self.frequencies = defaultdict()# freq: (key1, key2)
        self.min_freq = 0
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self.cache.keys():
            return -1
        freq, value = self.cache[key]
        self.frequencies[freq].pop(key)
        if not self.frequencies[freq]:
            self.frequencies.pop(freq)
            if self.min_freq == freq:
                self.min_freq += 1
        self.insert(key, value, freq + 1)
        return value

    def put(self, key: int, value: int) -> None:
        if self.capacity <= 0:
            return
        if key in self.cache.keys():
            freq = self.cache[key][0]
            self.cache[key] = (freq, value)
            self.get(key)
            return
        if self.capacity == len(self.cache):
            keys = self.frequencies[self.min_freq]
            keyToDelete = next(iter(next(iter(keys.items()))))
            self.cache.pop(keyToDelete)
            self.frequencies[self.min_freq].pop(keyToDelete)
            if not self.frequencies[self.min_freq]:
                self.frequencies.pop(self.min_freq)
        self.min_freq = 1
        self.insert(key, value, 1)
    def insert(self, key, value, freq):
        self.cache[key] = (freq, value)
        if freq not in self.frequencies:
            self.frequencies[freq] = defaultdict()
        self.frequencies[freq][key] = None


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)