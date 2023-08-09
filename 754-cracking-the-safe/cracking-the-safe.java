class Solution {
    int total;
    HashSet<String> visited;
    int n;
    int k;
    StringBuilder sb;
    public String crackSafe(int n, int k) {
        this.sb = new StringBuilder();
        this.total = (int)Math.pow(k, n);
        this.visited = new HashSet<>();
        this.n = n;
        this.k = k;

        for (int i = 0; i < n; i++) {
            sb.append('0');
        }

        
        visited.add(sb.toString());
        helper();
        return sb.toString();
    }

    private boolean helper() {
        if (visited.size() == total) {
            return true;
        }
        String prev = sb.substring(sb.length() - (n-1)).toString();
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (visited.contains(next)) continue;
            visited.add(next);
            sb.append(i);
            if (helper()) {
                return true;
            } else {
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}