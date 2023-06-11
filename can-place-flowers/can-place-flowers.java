class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && plantable(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return (n == 0);
    }

    private boolean plantable(int[] flowerbed, int index) {
        boolean left = (index == 0) || (flowerbed[index - 1] == 0);
        boolean right = (index == flowerbed.length - 1) || (flowerbed[index + 1] == 0);
        return (left && right);
    }
}