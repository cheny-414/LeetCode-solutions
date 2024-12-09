class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counts = Counter(arr)
        count_set = set()
        for count in counts.values():
            if count in count_set:
                return False
            else:
                count_set.add(count)
        return True