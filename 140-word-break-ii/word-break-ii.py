class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        def helper(start, end):
            ret = []
            for i in range(start, end + 1):
                string = s[start:i + 1]
                if string in wordDict:
                    if i + 1 < len(s):
                        sentences = helper(i + 1, end)
                        for sentence in sentences:
                            newSentence = string + ' ' + sentence
                            ret.append(newSentence)
                    else:
                        ret.append(string)
            return ret
        return helper(0, len(s) - 1)
                            