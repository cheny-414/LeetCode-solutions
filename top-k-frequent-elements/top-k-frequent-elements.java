class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int key : map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        List<Integer> flattened = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            for (int num : buckets[i]) {
                flattened.add(num);
            }
        }

        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = flattened.get(i);
        }
        return top;
    }
}