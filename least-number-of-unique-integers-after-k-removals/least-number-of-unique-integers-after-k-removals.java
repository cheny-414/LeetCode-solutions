class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> freq = new ArrayList<>();
        for (int i : map.keySet()) {
            freq.add(map.get(i));
        }

        Collections.sort(freq);
        int uniques = freq.size();

        for (int i = 0; i < freq.size(); i++) {
            if (freq.get(i) <= k) {
                k -= freq.get(i);
                uniques--;
            }
            else {
                return uniques;
            }
            
        }
        return 0;
    }
}