class Solution:
    def getKey(self, string: str) -> str:
        nums = []
        key = ""
        for i in string:
            nums.append(ord(i))
        nums.sort()
        for i in nums:
            key += chr(i)
        return key

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = {}
        result = []
        for string in strs:
            key = self.getKey(string)
            if key not in dic:
                dic[key] = [string]
            else:
                dic[key].append(string)
        
        for i in dic.values():
            result.append(i)
        return result