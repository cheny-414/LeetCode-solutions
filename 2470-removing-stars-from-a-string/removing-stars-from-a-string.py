class Solution:
    def removeStars(self, s: str) -> str:
        stack = deque()
        result = ''
        for char in s:
            if char != '*':
                stack.append(char)
            else:
                stack.pop()
        while stack:
            result += stack.popleft()
        return result