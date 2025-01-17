class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        #3, -2,     -2,     -3,     0,      4, 1, -2, 5
        #3, -6/N,   12,-2,  -36,6   0,0     4,None
        n = len(nums)
        if len(nums) == 1:
            return nums[0]
        largest = [] #best negative, best positive
        if nums[0] < 0:
            largest.append((nums[0], -inf))
        elif nums[0] > 0:
            largest.append((inf, nums[0]))
        else:
            largest.append((0, 0))
        for i in range(1, n):
            if nums[i] == 0:
                largest.append((0, 0))
            elif nums[i] > 0:
                negative = largest[i - 1][0] * nums[i]
                positive = max(nums[i], largest[i - 1][1] * nums[i])
                largest.append((negative, positive))
            else:
                negative = min(nums[i], largest[i - 1][1] * nums[i])
                positive = largest[i - 1][0] * nums[i]
                largest.append((negative, positive))
        return max([x[1] for x in largest])