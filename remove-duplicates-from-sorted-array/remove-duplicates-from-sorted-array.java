class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int curr = nums[0];
        boolean seen = false;
        Queue<Integer> uniques = new LinkedList<>();
        //ArrayList<Integer> uniques = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                uniques.add(nums[i]);
                curr = nums[i];
            }
        }
        int i = 1;
        while (!uniques.isEmpty()) {
            nums[i++] = uniques.poll();
        }
        return i;
    }
}