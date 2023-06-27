class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char prev = s.charAt(s.length() - 1);
        int answer = map.get(prev);
        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if (map.get(c) >= map.get(prev)) {
                answer += map.get(c);
            } else {
                answer -= map.get(c);
            }
            prev = c;
        }
        return answer;
    }
}