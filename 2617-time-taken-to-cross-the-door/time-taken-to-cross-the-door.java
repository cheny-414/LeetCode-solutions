class Solution {
    public class Person {
        int id;
        int arrivalTime;
        public Person(int id, int arrivalTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
        }
    }

    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Person> enterQueue = new ArrayDeque<>();
        Queue<Person> exitQueue = new ArrayDeque<>();
        for (int i = 0; i < arrival.length; i++) {
            if (state[i] == 0) {
                enterQueue.offer(new Person(i, arrival[i]));
            } else {
                exitQueue.offer(new Person(i, arrival[i]));
            }
        }
        int[] result = new int[arrival.length];
        int currTime = -1;
        int lastEnterTime = -1;
        int lastExitTime = -1;
        while (!enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            Person p1 = enterQueue.peek();
            Person p2 = exitQueue.peek();
            int t1 = p1 == null ? Integer.MAX_VALUE : p1.arrivalTime;
            int t2 = p2 == null ? Integer.MAX_VALUE : p2.arrivalTime;
            currTime = Math.max(currTime + 1, Math.min(t1, t2));
            t1 = Math.max(t1, currTime);
            t2 = Math.max(t2, currTime);
            if (p1 == null) {
                result[p2.id] = t2;
                exitQueue.poll();
            } else if (p2 == null) {
                result[p1.id] = t1;
                enterQueue.poll();
            } else {
                if (t1 < t2) {
                    result[p1.id] = lastEnterTime = t1;
                    enterQueue.poll();
                } else if (t1 > t2) {
                    result[p2.id] = lastExitTime = t2;
                    exitQueue.poll();
                } else {
                    if ((currTime - lastEnterTime > 1 && currTime - lastExitTime > 1) || currTime - lastExitTime == 1) {
                        result[p2.id] = lastExitTime = t2;
                        exitQueue.poll();
                    } else {
                        result[p1.id] = lastEnterTime = t1;
                        enterQueue.poll();
                    }
                }
            }
        }
        return result;
    }
}