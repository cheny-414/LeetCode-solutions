class Solution:
    def myAtoi(self, s: str) -> int:
        if not s:
            return 0
        pointer = 0
        res = ''
        sign = 1
        while pointer < len(s) and s[pointer] == ' ':
            pointer += 1
        if pointer < len(s):
            if s[pointer] == '-':
                sign = -1
                pointer += 1
            elif s[pointer] == '+':
                sign = 1
                pointer += 1
        while pointer < len(s) and s[pointer].isdigit():
            res += s[pointer]
            pointer += 1
        if not res:
            return 0
        num = int(res)
        if sign == 1 and num > 2**31 - 1:
            num = 2**31 - 1
        elif sign == -1 and num > 2**31:
            num = 2**31
        return num * sign