class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = [0] * n
        def dfs(room):
            visited[room] = 1
            keys = rooms[room]
            for key in keys:
                if not visited[key]:
                    dfs(key)
        dfs(0)
        return sum(visited) == n