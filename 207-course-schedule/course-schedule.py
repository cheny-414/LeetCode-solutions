class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #3
        #[0,1] [2,1] [1,0]
        indegree = [0] * numCourses
        adj = {}

        for prereq in prerequisites:
            if prereq[0] not in adj:
                adj[prereq[0]] = [prereq[1]]
            else:
                adj[prereq[0]].append(prereq[1])
            indegree[prereq[1]] += 1
        
        queue = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        nodesVisited = 0
        while queue:
            node = queue.popleft()
            nodesVisited += 1
            
            if node not in adj:
                continue
            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        return nodesVisited == numCourses