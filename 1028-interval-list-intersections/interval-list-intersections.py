class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        i = j = 0
        res = []
        m, n = len(firstList), len(secondList)
        if not firstList or not secondList:
            return res
        # while i < m and j < n and firstList[i][1] < secondList[j][0]:
        #     i += 1
        # while i < m and j < n and secondList[j][1] < firstList[i][0]:
        #     j += 1
        while i < m and j < n:
            if firstList[i][1] < secondList[j][0]:
                i += 1
            elif secondList[j][1] < firstList[i][0]:
                j += 1
            else:
                currIntersection = [max(firstList[i][0], secondList[j][0]), min(firstList[i][1], secondList[j][1])]
                res.append(currIntersection)
                if firstList[i][1] < secondList[j][1]:
                    i += 1
                elif firstList[i][1] > secondList[j][1]:
                    j += 1
                else:
                    i += 1
                    j += 1
        return res