class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        order_map = {}
        for i, char in enumerate(order):
            order_map[char] = i
        last_word = ""
        def less_than(word1, word2):
            if len(word1) == 0:
                return True
            if len(word2) == 0:
                return False
            p1 = 0
            p2 = 0
            while p1 < len(word1) and p2 < len(word2):
                if order_map[word1[p1]] > order_map[word2[p2]]:
                    return False
                elif order_map[word1[p1]] < order_map[word2[p2]]:
                    return True
                p1 += 1
                p2 += 1
            return p1 == len(word1)

        for word in words:
            if not less_than(last_word, word):
                return False
            last_word = word
        return True