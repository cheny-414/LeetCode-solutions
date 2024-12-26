class Solution:
    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        #0 none
        #1 0
        #2 0, 1
        #3 2
        #4 0, 3, 4
        #5 4
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
        # while stack:
        #     curr = stack.pop()
        #     if stack:
        #         res[stack[-1]] += 1
        return res
