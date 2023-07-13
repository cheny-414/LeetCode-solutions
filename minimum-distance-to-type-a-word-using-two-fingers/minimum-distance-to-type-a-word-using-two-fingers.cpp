int dp[301][27][27];
class Solution {
public:
    int findPos(char a){
        return a - 'A';
    }
    int findCost(int from, int to){
        if(from == 26) return 0;
        int r1 = from/6;
        int c1 = from%6;
        int r2 = to/6;
        int c2 = to%6;
        return abs(r1 - r2) + abs(c1 - c2);
    }
    int solve(int index, int finger1, int finger2, string& word){
        if(index == word.size()) return 0;
        if(dp[index][finger1][finger2] != -1) return dp[index][finger1][finger2];
        int newPos = findPos(word[index]);
        int cost1 = findCost(finger1, newPos);
        int cost2 = findCost(finger2, newPos);
        return dp[index][finger1][finger2] = min(cost1 + solve(index + 1, newPos, finger2, word), cost2 + solve(index + 1, finger1, newPos, word));
    }
    int minimumDistance(string word) {
        memset(dp, -1, sizeof(dp));
        return solve(0, 26, 26, word);
    }
};