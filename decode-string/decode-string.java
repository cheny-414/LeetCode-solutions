class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (Character.isDigit(s.charAt(index))) {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++; //ignore open bracket
                String decodedString = decodeString(s);
                index++; //ignore close bracket
                while (k > 0) {
                    sb.append(decodedString);
                    k--;
                }
            } else {
                sb.append(s.charAt(index));
                index++;
            }
        }
        return sb.toString();
    }
}