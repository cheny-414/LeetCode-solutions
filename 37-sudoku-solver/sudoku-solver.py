class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rowSets = defaultdict(set)
        colSets = defaultdict(set)
        blockSets = defaultdict(set)
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    rowSets[i].add(int(board[i][j]))
                    colSets[j].add(int(board[i][j]))
                    block = (i // 3) * 3 + j // 3
                    blockSets[block].add(int(board[i][j]))

        def fillable(start):
            for i in range(start, 81):
                row = i // 9
                col = i % 9
                block = (row // 3) * 3 + col // 3
                if board[row][col] == '.':
                    # try a num:
                    for j in range(1, 10):
                        if j not in rowSets[row] and j not in colSets[col] and j not in blockSets[block]:
                            rowSets[row].add(j)
                            colSets[col].add(j)
                            blockSets[block].add(j)
                            board[row][col] = str(j)
                            if fillable(i + 1):
                                return True
                            rowSets[row].remove(j)
                            colSets[col].remove(j)
                            blockSets[block].remove(j)
                            board[row][col] = '.'
                    return False
            return True
            
        return fillable(0)