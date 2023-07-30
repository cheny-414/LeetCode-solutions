class Solution {
    public int maxSumMinProduct(int[] nums) {
        //for this problem, we can quickly know the sum of an subarray with prefix sum array
        //so the difficult point is how to get the min value for each array very quickly
        //we can use segment tree
        //but this still O(N^2), since you will find for each pair of [i, j]
        //we can focus on each number in nums, let it be the min and we expand from this number to right and to left
        //we want to ask what is the first number on the right that is smaller than this number
        //and what is the first number on the left that is smaller than this number
        int n = nums.length;
        int mod = (int)(1e9 + 7);
        if (n == 1) return (int)(((long)nums[0] * (long)nums[0]) % mod);
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();
            st.add(i);
        }
        int[] right = new int[n];
        st = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) right[i] = n;
            else right[i] = st.peek();
            st.add(i);
        }

        long res = 0L;
        long[] preSum = new long[n];
        preSum[0] = (long)nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + (long)nums[i];
        }
        for (int i = 0; i < n; i++) {
            long sum = left[i] == -1 ? preSum[right[i]-1] : preSum[right[i]-1] - preSum[left[i]];
            long cur = (long)nums[i] * sum;
            res = Math.max(cur, res);
        }
        return (int)(res % mod);
    }
}