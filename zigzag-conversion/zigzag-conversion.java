class Solution {
    public String convert(String s, int numRows) {
        HashMap<Integer, String> map = new HashMap<>();
        int currRow = 0;
        boolean down = true;
        String answer = "";
        if (numRows == 1) return s;
        for (int i = 0; i < numRows; i++) {
            map.put(i, "");
        }

        for (int i = 0; i < s.length(); i++) {
            map.put(currRow, map.get(currRow) + s.charAt(i));
            if (currRow == 0) {
                down = true;
            } else if (currRow == numRows - 1) {
                down = false;
            }
            if (down) {
                currRow++;
            } else {
                currRow--;
            }
        }

        for (int i = 0; i < numRows; i++) {
            answer += map.get(i);
        }
        return answer;
    }
}