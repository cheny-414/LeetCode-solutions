class MyCalendar:

    def __init__(self):
        self.intervals = []

    def book(self, startTime: int, endTime: int) -> bool:
        interval = [startTime, endTime]
        if not self.intervals:
            self.intervals.append(interval)
            return True
        index = bisect_left(self.intervals, interval)
        if index > 0 and self.intervals[index - 1][1] > startTime:
            return False
        if index < len(self.intervals) and self.intervals[index][0] < endTime:
            return False
        self.intervals.insert(index, interval)
        return True



# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(startTime,endTime)