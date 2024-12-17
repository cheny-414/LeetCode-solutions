class Solution:
    def canWin(self, currentState: str) -> bool:
        dp = {}
        def helper(currentState):
            if currentState in dp:
                return dp[currentState]
            canWin = False
            for i in range(len(currentState) - 1):
                if currentState[i] == '+' and currentState[i + 1] == '+':
                    nextState = currentState[:i] + '--' + currentState[i + 2:]
                    opponentWin = helper(nextState)
                    if not opponentWin:
                        canWin = True
            dp[currentState] = canWin
            return canWin
        return helper(currentState)