class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int complement = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == complement) {
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    if (!set.contains(triplet)) {
                        answer.add(triplet);
                        set.add(triplet);
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > complement) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;
    }
}