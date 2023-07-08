class Solution {
    HashMap<String, Map<String, Double>> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denom = equation.get(1);
            double quotient = values[i];

            if(!map.containsKey(numerator)) {
                map.put(numerator, new HashMap<String, Double>());
            }
            if(!map.containsKey(denom)) {
                map.put(denom, new HashMap<String, Double>());
            }
            map.get(numerator).put(denom, quotient);
            map.get(denom).put(numerator, 1 / quotient);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0), denom = query.get(1);

            if (!map.containsKey(numerator) || !map.containsKey(denom)) {
                results[i] = -1.0;
            }
            else if (numerator == denom) {
                results[i] = 1.0;
            }
            else {
                HashSet<String> visited = new HashSet<>();
                results[i] = dfs(numerator, denom, 1, visited);
            }
        }

        return results;
    }

    private double dfs(String currNode, String targetNode, double accProduct, Set<String> visited) {
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbors = map.get(currNode);
        if (neighbors.containsKey(targetNode)) {
            ret = accProduct * neighbors.get(targetNode);
        }
        else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) {
                    continue;
                }
                ret = dfs(nextNode, targetNode, accProduct * pair.getValue(), visited);

                if (ret != -1.0) {
                    break;
                }
            }
        }

        //visited.remove(currNode);
        return ret;
    }
}