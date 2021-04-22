class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // Rewrite Array.sort with Comparator
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}

/*
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) ->{
            int index1 = log1.indexOf(" ") + 1;
            int index2 = log2.indexOf(" ") + 1;
            
            if(Character.isLetter(log1.charAt(index1)) &&
               Character.isLetter(log2.charAt(index2))){
                   int cmp = log1.substring(index1).compareTo(log2.substring(index2));      
                   if(cmp != 0) return cmp;
                
                   return log1.compareTo(log2);
               }else if(Character.isLetter(log1.charAt(index1))) return -1; //log1(c) < log2(d)
                else if(Character.isLetter(log2.charAt(index2))) return 1;  //log1(d) > log2(c)
                else return 0; //log1 == log2
                              
        });
                        
        return logs;
    }
}
*/