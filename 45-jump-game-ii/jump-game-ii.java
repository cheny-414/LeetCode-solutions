class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = nums[0];
        int jumps = 0;
        int index = 0;
        while (reach < nums.length - 1) {
            int max = reach;
            int jumpTo = index;
            for (int i = index; i <= reach; i++) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                    jumpTo = i;
                }
            }
            index = jumpTo;
            jumps++;
            reach = index + nums[index];
        }
        return jumps + 1;
    }
}