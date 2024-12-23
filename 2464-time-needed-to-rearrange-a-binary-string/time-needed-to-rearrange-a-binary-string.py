class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        changed = True
        nums = list(s)
        days = 0
        while changed:
            changed = False
            i = 1
            while i < len(s):
                if nums[i] == '1' and nums[i - 1] == '0': 
                    nums[i], nums[i - 1] = nums[i - 1], nums[i]
                    i += 1
                    changed = True
                i += 1
            days += changed
        return days