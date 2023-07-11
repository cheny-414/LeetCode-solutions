class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, List<String>> map = new HashMap<>();

        for (String word : words) {
            if (!map.containsKey(word.charAt(0))){
                map.put(word.charAt(0), new ArrayList<>());
            }
            map.get(word.charAt(0)).add(word);
        }

        for (char c : s.toCharArray()) {
            List<String> bucket = map.getOrDefault(c, new ArrayList<String>());
            map.remove(c);
            for (String string : bucket) {
                string = string.substring(1);
                if (string.equals("")) {
                    result++;
                    continue;
                }
                if (!map.containsKey(string.charAt(0))){
                    map.put(string.charAt(0), new ArrayList<>());
                }
                map.get(string.charAt(0)).add(string);
            }
        }
        return result;
    }
}