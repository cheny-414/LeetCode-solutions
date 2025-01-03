class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        counts = Counter()
        for i in range(9, len(s)):
            string = s[i - 9:i+1]
            counts[string] += 1
        res = []
        for string in counts:
            if counts[string] > 1:
                res.append(string)
        return res