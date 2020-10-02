String booleanDeque(int n, String[] operations) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    for (String op : operations) {
        if (op.equals("L")){
            for (int i = 0; i < n; i ++) {
                if (map.get(i) == null) {
                    map.put(i, 1);
                    break;
                }
            }
        } else if (op.charAt(0) == 'C') {
            int idx = Integer.parseInt(op.substring(1));
            if (map.get(idx) != null) {
                map.remove(idx);
            }
        }
    }
    
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < n; i ++) {
        str.append(map.getOrDefault(i, 0));
    }
    return str.toString();
}