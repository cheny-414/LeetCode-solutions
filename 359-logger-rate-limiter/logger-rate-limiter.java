class Logger {
    private final Map<String, Integer> messageExpTime;

    public Logger() {
        messageExpTime = new LinkedHashMap<>();
    }
    
    public synchronized boolean shouldPrintMessage(int timestamp, String message) {
        var iterator = messageExpTime.entrySet().iterator();
        while (iterator.hasNext() && iterator.next().getValue() + 10 <= timestamp) {
            iterator.remove();
        }

        if (messageExpTime.containsKey(message)) {
            return false;
        }
        messageExpTime.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */