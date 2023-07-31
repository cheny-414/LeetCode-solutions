class Solution {
    public int partitionString(String s) {
        //int left = 0;
        int right = 0;
        int n = s.length();
        int answer = 1;
        Set<Character> set = new HashSet<>();
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                //left = right;
                set.clear();
                answer++;
                set.add(s.charAt(right));
                right++;
            }
        }  
        return answer;      
    }
}