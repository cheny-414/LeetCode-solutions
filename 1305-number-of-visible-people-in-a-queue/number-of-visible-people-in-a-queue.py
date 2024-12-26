class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        n = len(heights)
        res = [0] * n
        stack = deque()
        for i in range(n):
            while stack and heights[i] > heights[stack[-1]]:
                lastPerson = stack.pop()
                res[lastPerson] += 1
            if stack:
                res[stack[-1]] += 1
            stack.append(i)
        return res
