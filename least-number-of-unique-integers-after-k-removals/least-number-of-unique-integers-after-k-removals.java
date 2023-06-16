class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> freq = new PriorityQueue<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i : map.keySet()) {
            freq.offer(map.get(i));
        }

        while(!freq.isEmpty()) {
            if (freq.peek() <= k) {
                k -= freq.poll();
            }
            else {
                return freq.size();
            }
            
        }
        return 0;
    }
}