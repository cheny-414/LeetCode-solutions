class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = {}
        answer = []
        visited = set()
        def dfs(num, den, val_so_far):
            visited.add(num)
            if num in graph and den in graph[num]:
                return graph[num][den] * val_so_far
            for neighbor in graph[num]:
                find = float('inf')
                if neighbor not in visited:
                    result = dfs(neighbor, den, val_so_far * graph[num][neighbor])
                    if result != float('inf'):
                        find = result
                        break
            return find
        for i in range(len(values)):
            num = equations[i][0]
            den = equations[i][1]
            val = values[i]
            if num not in graph:
                graph[num] = {}
            if den not in graph:
                graph[den] = {}
            graph[num][den] = val
            graph[den][num] = 1/val
        for query in queries:
            num = query[0]
            den = query[1]
            if num in graph and den in graph[num]:
                answer.append(graph[num][den])
            elif num not in graph or den not in graph:
                answer.append(-1.0)
            elif num == den:
                answer.append(1.0)
            else:
                result = dfs(num, den, 1)
                if result != float('inf'):
                    if num not in graph:
                        graph[num] = {}
                    graph[num][den] = result
                answer.append(-1.0 if result == float('inf') else result)
            visited.clear()
        return answer
        
        