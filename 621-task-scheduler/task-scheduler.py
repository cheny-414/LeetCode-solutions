class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26
        for task in tasks:
            freq[ord(task) - ord('A')] += 1
        freq.sort(reverse = False)
        max_freq = freq[25] - 1
        idle_slots = max_freq * n
        for i in range (24, -1, -1):
            idle_slots -= min(max_freq, freq[i])
        return max(len(tasks), len(tasks) + idle_slots)