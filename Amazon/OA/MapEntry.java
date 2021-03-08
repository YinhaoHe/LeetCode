import java.util.Map;

class test {
    public static class MyEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
    
        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        @Override
        public K getKey() {
            return key;
        }
    
        @Override
        public V getValue() {
            return value;
        }
    
        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
    public static int func() {
        int res = Integer.MIN_VALUE;

        ArrayDeque<Map.Entry<Integer, Integer>> mins = new ArrayDeque<>();
        
        for (int i = 0; i < hardDiskSpace.size(); i ++) {
            int tmp = hardDiskSpace.get(i);
            if (mins.size() > 0 && mins.getFirst().getKey() <= i - segmentLength) {
                mins.pollFirst();
            }
            
            while (mins.size() > 0 && mins.getLast().getValue() >= tmp) {
                mins.pollLast();
            }
            mins.addLast(new MyEntry<Integer, Integer>(i, tmp));
            if (i >= segmentLength) {
                res = Math.max(res, mins.getFirst().getValue());
            }
            System.out.println(res);
        }
        return res;
    }

}
