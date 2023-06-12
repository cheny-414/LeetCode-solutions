class SmallestInfiniteSet {
    int i = 1;
    HashSet<Integer> isPresent = new HashSet<>();
    PriorityQueue<Integer> addedBack = new PriorityQueue<>();
    public SmallestInfiniteSet() {
        
    }
    
    public int popSmallest() {
        int answer;
        if (!addedBack.isEmpty()) {
            answer = addedBack.poll();
            isPresent.remove(answer);
        }
        else {
            answer = i++;
        }
        return answer;
    }
    
    public void addBack(int num) {
        if (i <= num || isPresent.contains(num)) {
            return;
        }
        addedBack.add(num);
        isPresent.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */