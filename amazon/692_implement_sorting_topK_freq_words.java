class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // initial idea is to implement sort() from collection Class
        
        // count words
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        List<String> topKwords = new ArrayList(count.keySet());
        Collections.sort(topKwords, (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
        
        return topKwords.subList(0, k);
    }
}