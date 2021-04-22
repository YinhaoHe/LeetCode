class LRUCache {
    // 使用双向链表和哈希表共同实现
    // Step inplement doublelinkedlist
    
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev; // 用于存储前一个节点
        DLinkedNode next; // 用于存储后一个节点
    }
    
    private DLinkedNode head, tail;
    
    private void addNode (DLinkedNode node) {
        //在head后面加node
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode (DLinkedNode node) {
        DLinkedNode prev = node.prev; // 记录node前一个
        DLinkedNode next = node.next; // 记录node后一个
        
        prev.next = next; // node前一个的next 等于 node的下一个 相当于跳过了node
        next.prev = prev; // node下一个的prev 等于 node的前一个 相当于跳过了node
    }
    
    // In order to implement LRU, we need to pick a node and move it to the head 
    private void moveToHead (DLinkedNode node) {
        removeNode(node); // 先删除再添加相当于移动到了head
        addNode(node); 
    }
    
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    private int size;
    private int capacity;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
 
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            
            if(size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */