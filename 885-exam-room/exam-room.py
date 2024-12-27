class ExamRoom:

    def __init__(self, n: int):
        self.students = []
        self.n = n

    def seat(self) -> int:
        if not self.students:
            self.students.append(0)
            return 0
        # elif len(self.students) == 1:
        #     bestSeat = self.n - 1 if self.students[0] <= self.n // 2 else 0
        #     index = bisect_left(self.students, bestSeat)
        #     self.students.insert(index, bestSeat)
        #     return bestSeat
        else:
            maxDistance = self.students[0]
            bestSeat = 0
            for i in range(1, len(self.students)):
                student1 = self.students[i - 1]
                student2 = self.students[i]
                distance = (student2 - student1) // 2
                if distance > maxDistance:
                    maxDistance = distance
                    bestSeat = student1 + distance
            d = self.n - 1 - self.students[-1]
            if d > maxDistance:
                bestSeat = self.n - 1
            # index = bisect_left(self.students, bestSeat)
            # self.students.insert(index, bestSeat)
            insort(self.students, bestSeat)
            return bestSeat
    def leave(self, p: int) -> None:
        # index = bisect_left(self.students, p)
        # self.students.pop(index)
        my = self.students
        self.students.remove(p)


# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)

#0, 1, 2, 3, 4, 5, 6, 7, 8, 9
#                           *