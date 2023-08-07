class Solution {
    public int findDuplicate(int[] nums) {
        int index = 0;  // 
        while (true) {
            index = Math.abs(nums[index]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index]; 
        }
    }
}