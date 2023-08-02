class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int j = binarySearch(list, num);
                list.set(j, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= num) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}