class Solution {
    public boolean isHappy(int n) {
        String str = String.valueOf(n);
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        while (sum != 1) {
            sum = 0;
            for (char c : str.toCharArray()) {
                int digit = c - '0';
                sum += Math.pow(digit, 2);
            }
            if (set.contains(sum)) return false;
            set.add(sum);
            str = String.valueOf(sum);
        }
        
        return true;
    }
}