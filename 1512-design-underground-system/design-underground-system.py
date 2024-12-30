class UndergroundSystem:

    def __init__(self):
        self.users = defaultdict(tuple)
        self.stations = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.users[id] = (stationName, t)

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        time = t - self.users[id][1]
        start = self.users[id][0]
        end = stationName
        self.users[id] = []
        if start not in self.stations:
            self.stations[start] = {}
        if end not in self.stations[start]:
            self.stations[start][end] = [0, 0]
        self.stations[start][end][0] += time
        self.stations[start][end][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        totalTime = self.stations[startStation][endStation][0]
        count = self.stations[startStation][endStation][1]
        return totalTime / count


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)