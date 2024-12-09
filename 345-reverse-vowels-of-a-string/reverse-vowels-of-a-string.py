class Solution:
    def reverseVowels(self, s: str) -> str:
        stack = deque()
        string = list(s)
        for i, char in enumerate(string):
            if char.lower() in ('a', 'e', 'i', 'o', 'u'):
                stack.append(char)
                string[i] = '_'
        for i, char in enumerate(string):
            if char == '_':
                string[i] = stack.pop()
        return ''.join(string)