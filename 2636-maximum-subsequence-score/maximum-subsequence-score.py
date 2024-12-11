class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        pairs = []
        for i in range(len(nums1)):
            val1, val2 = nums1[i], nums2[i]
            pairs.append((-val2, val1))
        pairs.sort()
        k_heap = [x[1] for x in pairs[:k]]
        heapify(k_heap)
        k_sum = sum(k_heap)
        result = k_sum * (-pairs[k - 1][0])
        for i in range(k, len(pairs)):
            height = -pairs[i][0]
            k_sum -= heappop(k_heap)
            heappush(k_heap, pairs[i][1])
            k_sum += pairs[i][1]
            result = max(result, height * k_sum)
        return result

