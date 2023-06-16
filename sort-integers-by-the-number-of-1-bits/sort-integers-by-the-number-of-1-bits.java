class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int compare = a[1] - b[1]; 
            if (compare == 0) compare = a[0] - b[0]; 
            return compare;});
        for (int num : arr) {
            String binary = Integer.toBinaryString(num);
            int count = 0;
            for (char i : binary.toCharArray()) {
                if (i == '1') {
                    count++;
                }
            }
            pq.offer(new int[]{num, count});
        }

        int[] result = new int[arr.length];
        int i = 0;
        while(!pq.isEmpty()) {
            result[i++] = pq.poll()[0];
        }
        return result;
    }
}