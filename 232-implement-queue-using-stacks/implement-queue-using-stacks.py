class MyQueue:

    def __init__(self):
        self.s1 = deque()
        self.s2 = deque()
        self.front = -1

    def push(self, x: int) -> None:
        if not self.s1: 
            self.front = x
        while self.s1:
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        while self.s2:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        result = self.s1.pop()
        if self.s1:
            self.front = self.s1[-1]
        return result

    def peek(self) -> int:
        return self.front

    def empty(self) -> bool:
        return False if self.s1 else True


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()