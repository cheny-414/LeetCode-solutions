class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int start = sorted.length, end = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (start < end ? end - start + 1 : 0);
    }
}