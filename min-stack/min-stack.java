class MinStack {
    HashMap<Integer, Stack<Integer>> map;
    List<Integer> list;
    int globalMin;
    public MinStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
        globalMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new Stack<Integer>());
        }
        if (val <= globalMin) {
            map.get(val).push(list.size() - 1);
            globalMin = val;
        } else {
            map.get(val).push(map.get(list.get(list.size() - 2)).peek());
        }
        
    }
    
    public void pop() {
        if (list.isEmpty()) return;
        int val = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        map.get(val).pop();

        if (list.isEmpty()) {
            globalMin = Integer.MAX_VALUE;
        } else {
            globalMin = list.get(map.get(list.get(list.size() - 1)).peek());
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return globalMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */