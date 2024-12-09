class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count1 = Counter(word1)
        count2 = Counter(word2)
        return sorted(count1.keys()) == sorted(count2.keys()) and sorted(count1.values()) == sorted(count2.values())