class SmallestInfiniteSet:

    def __init__(self):
        self.heap = []
        self.pointer = 1
        self.unique_heap = set()
    def popSmallest(self) -> int:
        if not self.heap:
            ret = self.pointer
            self.pointer += 1
            return ret
        else:
            val = heapq.heappop(self.heap)
            self.unique_heap.remove(val)
            return val
    def addBack(self, num: int) -> None:
        if self.pointer > num and num not in self.unique_heap:
            heapq.heappush(self.heap, num)
            self.unique_heap.add(num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)