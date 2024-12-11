class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        provinces = 0
        visited = [0] * len(isConnected)
        def explore(i):
            visited[i] = 1
            for j in range(len(isConnected)):
                if isConnected[i][j] == 1 and not visited[j]:
                    explore(j)
        for i in range(len(isConnected)):
            if not visited[i]:
                provinces += 1
                explore(i)
        return provinces