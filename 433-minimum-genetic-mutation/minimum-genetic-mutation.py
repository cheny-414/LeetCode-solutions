class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        geneBank = set(bank)
        visited = {startGene}
        q = deque([startGene])
        steps = 0

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == endGene:
                    return steps
                for i in range(8):
                    for char in ('A', 'C', 'G', 'T'):
                        newString = curr[:i] + char + curr[i + 1:]
                        if newString in geneBank and newString not in visited: 
                            q.append(newString)
                            visited.add(newString)
            steps += 1
        return -1