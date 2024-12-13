# """
# This is Master's API interface.
# You should not implement it, or speculate about its implementation
# """
# class Master:
#     def guess(self, word: str) -> int:

class Solution:
    def findSecretWord(self, words: List[str], master: 'Master') -> None:
        words = set(words)
        info = {}
        while len(words) > 0:
            w = words.pop()  # randomly pick a word
            n_match = master.guess(w)
            info[w] = n_match
            # remove all impossible words
            to_remove = set()
            for i in words:
                for j in info:
                    n = 0
                    for k in range(6):
                        if i[k] == j[k]:
                            n += 1
                    if n != info[j]:
                        to_remove.add(i)
                        break
            for i in to_remove:
                if i in words:
                    words.remove(i)