class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFreq = new HashMap<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result++;
            }
            if (prefixFreq.containsKey(sum - k)) {
                result += prefixFreq.get(sum - k);
            }
            prefixFreq.put(sum, prefixFreq.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}


// 1, 1, 1, k = 2
// output: 2
// 1, 2, 3

// 3,  4,  7, -2,  2,  1,  4,  2   k = 7
// 3,  7, 14, 12, 14, 15, 19, 21