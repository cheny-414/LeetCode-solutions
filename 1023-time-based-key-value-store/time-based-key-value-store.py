class TimeMap:

    def __init__(self):
        self.store = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append((timestamp, value))
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.store or not self.store[key]:
            return ""
        left = 0
        right = len(self.store[key]) - 1
        idx = -1
        while left <= right:
            mid = left + (right - left) // 2
            if self.store[key][mid][0] <= timestamp:
                idx = mid
                left = mid + 1
            else:
                right = mid - 1
        return "" if idx == -1 else self.store[key][idx][1]

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)