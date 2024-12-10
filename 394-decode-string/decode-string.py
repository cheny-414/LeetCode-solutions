class Solution:
    def decodeString(self, s: str) -> str:
        stack = deque()
        for char in s:
            if char == ']':
                temp = deque()
                while stack[-1] != '[':
                    temp.appendleft(stack.pop())
                # pop the [
                stack.pop()
                # pop the num
                mult = 1
                count = 0
                temp_s = ""
                while stack and stack[-1].isnumeric():
                    count += int(stack.pop()) * mult
                    mult *= 10
                for i in range(count):
                    temp_s += ''.join(temp)
                stack.append(temp_s)
            else:
                stack.append(char)
        return ''.join(stack)