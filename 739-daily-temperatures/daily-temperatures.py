class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        days = len(temperatures)
        answer = [0] * days
        stack = []
        for i, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                old_index = stack.pop()
                diff = i - old_index
                answer[old_index] = diff
            stack.append(i)
        while stack:
            answer[stack.pop()] = 0
        return answer