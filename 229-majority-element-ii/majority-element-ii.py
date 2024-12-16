class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        candidate1 = None
        candidate2 = None

        count1 = 0
        count2 = 0

        for num in nums:
            if num != candidate2 and (num == candidate1 or candidate1 == None):
                candidate1 = num
                count1 += 1
            elif num == candidate2 or candidate2 == None:
                candidate2 = num
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1
                if count1 == 0:
                    candidate1 = None
                if count2 == 0:
                    candidate2 = None
        #second pass
        result = []
        if candidate1 != None and nums.count(candidate1) > len(nums) // 3:
            result.append(candidate1)
        if candidate2 != None and nums.count(candidate2) > len(nums) // 3:
            result.append(candidate2)
        return result
        