class Solution:
    def minSwaps(self, data: List[int]) -> int:
        count = data.count(1)
        zeroes = 0
        for i in range(count):
            if data[i] == 0:
                zeroes += 1
        minSwaps = zeroes
        for i in range(count, len(data)):
            if data[i - count] == 0:
                zeroes -= 1
            if data[i] == 0:
                zeroes += 1
            minSwaps = min(minSwaps, zeroes)
        return minSwaps