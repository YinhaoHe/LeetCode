class Node {
    Node next;
    int val;
    public Node(){}
    public Node(int val){this.val = val;}
}
class MyLinkedList {

    /** Initialize your data structure here. */
  
    Node dummyHead = new Node();
    Node head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
        dummyHead.next = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = dummyHead.next;
        for (int i = 0; i <= index; ++ i) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummyHead.next.next;
        dummyHead.next.next = newNode;
        size ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node cur = dummyHead.next;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node newNode = new Node(val);
        Node cur = dummyHead.next;
        while (index > 0) {
            cur = cur.next;
            index --;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size ++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node cur = dummyHead.next;
    
        while (index > 0) {
            cur = cur.next;
            index --;
        }
        cur.next = cur.next.next;
        size --;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */