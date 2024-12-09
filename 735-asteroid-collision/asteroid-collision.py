class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = deque()
        for ast in asteroids:
            if ast < 0:
                while stack and stack[-1] > 0 and stack[-1] < -ast:
                    stack.pop()
                if not stack or stack[-1] < -ast:
                    stack.append(ast)
                elif stack[-1] == -ast:
                    stack.pop()
            else:
                stack.append(ast)
        return list(stack)