class Solution:
    def sameEndSubstringCount(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        prefix_sum = [[0] * n for _ in range(26)]
        for i, char in enumerate(s):
            prefix_sum[ord(char) - ord("a")][i] = 1
        for freq in prefix_sum:
            for j in range(1, n):
                freq[j] += freq[j - 1]
        
        result = []
        for left, right in queries:
            count = 0
            for freq in prefix_sum:
                left_freq = 0 if left == 0 else freq[left - 1]
                right_freq = freq[right]
                freq_in_range = right_freq - left_freq
                count += (freq_in_range * (freq_in_range + 1)) // 2
            result.append(count)
        return result