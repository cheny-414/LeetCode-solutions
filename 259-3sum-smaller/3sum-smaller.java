class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int answer = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1; 
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    answer += (right - left);
                    left++;
                }
            }
        }
        return answer;
    }
}