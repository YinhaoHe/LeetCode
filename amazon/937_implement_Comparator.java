class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // implement Comparator
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            
            if(!isDigit1 && !isDigit2) {
                // both letter
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp; 
                // if log content start with same letter, then compare identifier
                else return split1[0].compareTo(split2[0]);
            } else if (isDigit1 && isDigit2) {
                // both num, stay unchanged original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first dig, second letter; then bring letter to forward
                return 1;
            } else {
                // first letter, second dig. unchanged
                return -1;
            }
        });
        return logs;
    }
}