class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26
        for task in tasks:
            freq[ord(task) - ord('A')] += 1
        freq.sort(reverse = True)
        max_freq = freq[0] - 1
        idle_slots = max_freq * n
        for i in range (1, 26):
            idle_slots -= min(max_freq, freq[i])
        return max(len(tasks), len(tasks) + idle_slots)