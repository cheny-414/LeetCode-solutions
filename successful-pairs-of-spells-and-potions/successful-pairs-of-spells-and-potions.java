class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] answer = new int[spells.length];

        int m = potions.length;
        int maxPotion = potions[m-1];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            long minPotion = (long) Math.ceil(success * 1.0/spell);

            if (minPotion > maxPotion) {
                answer[i] = 0;
                continue;
            }
            int index = binarySearch(potions, (int) minPotion);
            answer[i] = m - index;
        }

        return answer;
    }

    private int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}