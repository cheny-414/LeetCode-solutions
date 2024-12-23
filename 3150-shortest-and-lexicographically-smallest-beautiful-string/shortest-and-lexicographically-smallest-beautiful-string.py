class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        count = 0
        left = 0
        shortest = float('inf')
        for right in range(len(s)):
            if s[right] == '1':
                count += 1
            #if count == k:
            while count == k:
                count -= s[left] == '1'
                left += 1
                shortest = min(shortest, right - left + 2)
        count = 0
        if shortest == float('inf'):
            return ""
        for i in range(shortest):
            count += s[i] == '1'
        ret = float('inf')
        if count == k:
            ret = int(s[:shortest])
        for i in range(shortest, len(s)):
            count += s[i] == '1'
            count -= s[i - shortest] == '1'
            if count == k and int(s[i - shortest + 1:i + 1]) < ret:
                ret = int(s[i - shortest + 1:i + 1])
        return str(ret)