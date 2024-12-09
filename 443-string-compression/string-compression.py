class Solution:
    def compress(self, chars: List[str]) -> int:
        # fast = 0
        slow = 0
        currChar = ''
        count = 0
        for i in range(len(chars)):
            if i != 0 and chars[i] != chars[i - 1]:
                #write to list
                chars[slow] = currChar
                slow += 1
                if count != 1:
                    str_count = str(count)
                    for char in str_count:
                        chars[slow] = char
                        slow += 1
                #update
                currChar = chars[i]
                count = 1
            elif i == 0:
                currChar = chars[0]
                count = 1
            else:
                count += 1
        chars[slow] = currChar
        slow += 1
        if count != 1:
            str_count = str(count)
            for char in str_count:
                chars[slow] = char
                slow += 1
        return slow
