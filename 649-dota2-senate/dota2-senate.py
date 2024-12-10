class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        q = deque(list(senate))
        q1 = deque()
        q2 = deque()
        while len(q) > 1:
            while q:
                curr = q.popleft()
                if not q1 or q1[-1] == curr:
                    q1.append(curr)
                else:
                    q2.append(q1.popleft())
            if not q2:
                return 'Radiant' if q1.pop() == 'R' else 'Dire'
            q = q1 + q2
            q1.clear()
            q2.clear()
        return 'Radiant' if q.pop() == 'R' else 'Dire'
