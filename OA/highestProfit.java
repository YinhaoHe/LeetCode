public static int findProfit(List[] inventory, int order){
    HashMap<Integer, Integer> hm = new HashMap<>();
    int res = 0;
    int max = 0;
    for(int i = 0; i < inventory.size();i++){
        if(hm.containsKey(inventory.get(i))){
            hm.put(inventory.get(i),hm.getOrDefault(inventory.get(i), 0) + 1);
        }else{
            hm.put(inventory.get(i), 1);
        }
        max = Math.max(max, inventory.get(i));
    }
    while (order > 0) {
        int tempOrder = Math.min(hm.get(max), order);
        res += tempOrder * max; 
        order -= tempOrder;
        hm.remove(max);
        if (hm.containsKey(max - 1)) {
            hm.put(max - 1,hm.getOrDefault(max - 1, 0) + tempOrder);
        } else {
            hm.put(max - 1, tempOrder);
        }
        max = max - 1;
    }
    return res;
}