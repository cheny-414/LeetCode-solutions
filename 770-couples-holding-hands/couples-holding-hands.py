class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        #0, 1, 2, 7, 4, 5, 6, 3, 8, 9
        ans = 0
        map = {}
        for i, num in enumerate(row):
            map[num] = i
        for i in range(0, len(row), 2):
            x = row[i]
            partner = x ^ 1
            if row[i + 1] == partner:
                continue
            ans += 1
            index = map[partner]
            toSwap = row[i + 1]
            #swap in row:
            row[i + 1], row[index] = row[index], row[i + 1]
            #swap in map:
            map[toSwap] = index
            map[partner] = i + 1
        return ans