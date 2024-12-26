class SummaryRanges:

    def __init__(self):
        self.intervals = []
        self.unique = set()

    def addNum(self, value: int) -> None:
        if value in self.unique:
            return
        interval = [value, value]
        newIntervals = []
        i = 0
        appended = False
        if not self.intervals:
            self.intervals.append(interval)
            return
        while i < len(self.intervals):
            curr = self.intervals[i]
            if curr[1] + 1 < value:
                newIntervals.append(curr)
            elif curr[1] + 1 == value:
                new = [curr[0], value]
                if i < len(self.intervals) - 1 and value + 1 == self.intervals[i + 1][0]:
                    new = [curr[0], self.intervals[i + 1][1]]
                    i += 1
                newIntervals.append(new)
                appended = True
            elif value + 1 == curr[0]:
                newIntervals.append([value, curr[1]])
                appended = True
            elif value + 1 < curr[0]:
                if not appended:
                    newIntervals.append(interval)
                    appended = True
                newIntervals.append(curr)
            i += 1
        if not appended:
            newIntervals.append(interval)
        self.intervals = newIntervals.copy()
        self.unique.add(value)
    def getIntervals(self) -> List[List[int]]:
        return self.intervals


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()