class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        counter = Counter(s)
        for i in range(len(s)):
            char = s[i]
            if counter[char] == 1:
                return i
        return -1
        