class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj = defaultdict(list)
        indegree = {}
        q = deque()
        result = []

        for dest, source in prerequisites:
            adj[source].append(dest)
            if dest not in indegree:
                indegree[dest] = 0
            indegree[dest] += 1

        for node in range(numCourses):
            if node not in indegree or indegree[node] == 0:
                q.append(node)

        while q:
            curr = q.popleft()
            result.append(curr)
            for neighbor in adj[curr]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)
        return result if len(result) == numCourses else []