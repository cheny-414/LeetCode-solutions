class MyCalendarThree:

    def __init__(self):
        self.startTimes = []
        self.endTimes = []

    def book(self, startTime: int, endTime: int) -> int:
        self.startTimes.append(startTime)
        self.endTimes.append(endTime)
        self.startTimes.sort()
        self.endTimes.sort()
        i = j = k = 0
        ret = 0
        while i < len(self.startTimes):
            if self.startTimes[i] < self.endTimes[j]:
                i += 1
                k += 1
            else:
                j += 1
                k -= 1
            ret = max(ret, k)
        return ret



# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(startTime,endTime)