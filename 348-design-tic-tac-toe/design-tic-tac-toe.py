class TicTacToe:

    def __init__(self, n: int):
        #self.board = [[0] * n for _ in range(n)]
        self.dict1 = defaultdict(int)
        self.dict2 = defaultdict(int)
        self.n = n

    def move(self, row: int, col: int, player: int) -> int:
        if player == 1:
            self.dict1[row + 2] += 1
            self.dict1[-(col + 2)] += 1
            if row == col:
                self.dict1[0] += 1
            if row + col == self.n - 1:
                self.dict1[1] += 1
            if self.dict1[row + 2] == self.n or self.dict1[-(col + 2)] == self.n or self.dict1[0] == self.n or self.dict1[1] == self.n:
                return 1
        if player == 2:
            self.dict2[row + 2] += 1
            self.dict2[-(col + 2)] += 1
            if row == col:
                self.dict2[0] += 1
            if row + col == self.n - 1:
                self.dict2[1] += 1
            if self.dict2[row + 2] == self.n or self.dict2[-(col + 2)] == self.n or self.dict2[0] == self.n or self.dict2[1] == self.n:
                return 2
        return 0

# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)