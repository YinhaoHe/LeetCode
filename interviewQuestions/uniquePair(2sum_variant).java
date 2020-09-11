public static int stockPairs(List<Integer> stocksProfit, long target) {
    // Write your code here
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> used = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < stocksProfit.size(); i ++) {
            if (set.contains((int)target - stocksProfit.get(i)) && !used.contains(stocksProfit.get(i))) {
                count ++;
                used.add((int)target - stocksProfit.get(i));
                used.add(stocksProfit.get(i));
            }
            else if (!set.contains(stocksProfit.get(i))) {
                set.add(stocksProfit.get(i));
            }
        }
        return count;
    }

}