class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        distances = [float('inf')] * n
        distances[src] = 0

        for i in range(k + 1):
            new_distances = distances.copy()

            for source, dest, price in flights:
                # if distances[source] == float('inf'):
                #     continue
                if distances[source] + price < new_distances[dest]:
                    new_distances[dest] = distances[source] + price
            distances = new_distances
        return -1 if distances[dst] == float('inf') else distances[dst]
            