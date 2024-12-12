class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        left_heap = costs[:candidates]
        right_heap = costs[max(candidates, len(costs) - candidates):]
        heapify(left_heap)
        heapify(right_heap)
        left_pointer = candidates
        right_pointer = len(costs) - candidates - 1
        cost = 0
        for i in range(k):
            if not right_heap or left_heap and left_heap[0] <= right_heap[0]:
                cost += heappop(left_heap)
                if left_pointer <= right_pointer:
                    heappush(left_heap, costs[left_pointer])
                    left_pointer += 1
            else:
                cost += heappop(right_heap)
                if left_pointer <= right_pointer:
                    heappush(right_heap, costs[right_pointer])
                    right_pointer -= 1
        return cost
