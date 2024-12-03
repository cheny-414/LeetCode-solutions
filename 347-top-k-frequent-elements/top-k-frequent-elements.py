class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        unique = list(count.keys())
        
        def partition(left, right, pivot) -> int:
            pivot_freq = count[unique[pivot]]

            unique[pivot], unique[right] = unique[right], unique[pivot]

            store_index = left
            for i in range(left, right):
                if count[unique[i]] < pivot_freq:
                    unique[store_index], unique[i] = unique[i], unique[store_index]
                    store_index += 1
            unique[store_index], unique[right] = unique[right], unique[store_index]
            return store_index

        def quickselect(left, right, k) -> None:
            if left == right:
                return
            random_pivot = random.randint(left, right)
            pivot_index = partition(left, right, random_pivot)
            if k == pivot_index:
                return
            elif k > pivot_index:
                quickselect(pivot_index + 1, right, k)
            else:
                quickselect(left, pivot_index - 1, k)

        n = len(unique)
        quickselect(0, n - 1, n - k)
        return unique[n-k:]
