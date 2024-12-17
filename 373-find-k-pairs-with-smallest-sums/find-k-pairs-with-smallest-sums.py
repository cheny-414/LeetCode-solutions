class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        pq = []
        res = []
        visited = set((0, 0))
        heappush(pq, ((nums1[0] + nums2[0]), 0, 0))

        for i in range(k):
            curr = heappop(pq)
            curr_i = curr[1]
            curr_j = curr[2]
            res.append([nums1[curr_i], nums2[curr_j]])
            if curr_i + 1 < len(nums1) and (curr_i + 1, curr_j) not in visited:
                visited.add((curr_i + 1, curr_j))
                heappush(pq, ((nums1[curr_i + 1] + nums2[curr_j]), curr_i + 1, curr_j))
            if curr_j + 1 < len(nums2) and (curr_i, curr_j + 1) not in visited:
                heappush(pq, ((nums1[curr_i] + nums2[curr_j + 1]), curr_i, curr_j + 1))
                visited.add((curr_i, curr_j + 1))
        return res
            