class Solution {
    public int uniqueLetterString(String s) {
        List<Integer>[] record = new ArrayList[26];
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            if (record[c] == null) {
                record[c] = new ArrayList<>();
            }
            record[c].add(i);
        }

        for (int i = 0; i < 26; i++) {
            int size = record[i] == null ? 0 : record[i].size();
            for (int j = 0; j < size; j++) {
                int pos = record[i].get(j);
                int leftPos = j == 0 ? -1 : record[i].get(j - 1);
                int rightPos = j == size - 1 ? n : record[i].get(j + 1);
                result += (pos - leftPos) * (rightPos - pos);
            }
            
        }
        return result;
    }
}