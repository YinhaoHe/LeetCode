class Logger {
    
    // 1. use HashMap to store and lookup message O(1)
    // 2. if not exist add to map Otherwise plus 10 on the timestamp;
    // 3. if exists, need to compare the new timestamp with the old one to see if the difference is over 10
    
    private HashMap<String, Integer> log;

    /** Initialize your data structure here. */
    public Logger() {
        log = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.log.containsKey(message)) {
            this.log.put(message, timestamp);
            return true;
        } else {
            int oldMessage = log.get(message);
            if (timestamp - oldMessage >= 10) {
                this.log.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */