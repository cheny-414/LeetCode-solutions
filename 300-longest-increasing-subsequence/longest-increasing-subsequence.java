class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return 0;
        //int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int pos = Arrays.binarySearch(list.toArray(), nums[i]);
            if (pos >= 0) continue;
            else if (-(pos) > list.size()) {
                list.add(nums[i]);
                //size++;
            }
            else {
                list.set(-pos-1, nums[i]);
            }
        }
        return list.size();
    }
}