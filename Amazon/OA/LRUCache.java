import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static class LRUCache {
        private static class DLL {
            public int key;
            public int val;
            public DLL next;
            public DLL prev;

            public DLL(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public int capacity;
        public HashMap<Integer, DLL> cache;
        public DLL head;
        public DLL tail;
        public int size;

        public LRUCache(int capacity) {
            // WRITE YOUR BRILLIANT CODE HERE
            this.cache = new HashMap<>(capacity);
            this.head = new DLL(0, 0);
            this.tail = new DLL(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
            this.size = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            // AND HERE
            if (this.cache.containsKey(key)) {
                DLL loc = this.cache.get(key);
                loc.prev.next = loc.next;
                loc.next.prev = loc.prev;
                this.head.next.prev = loc;
                loc.next = this.head.next;
                this.head.next = loc;
                loc.prev = this.head;
                return loc.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            // AND HERE
            if (this.cache.containsKey(key)) {
                get(key);
                this.cache.get(key).val = value;
                return;
            }
            this.size++;
            if (this.size > this.capacity) {
                DLL lru = this.tail.prev;
                cache.remove(lru.key);
                this.tail.prev.val = this.tail.val;
                this.tail.prev.next = null;
                this.tail = this.tail.prev;
                this.size--;
            }
            DLL newHead = new DLL(key, value);
            this.head.next.prev = newHead;
            newHead.next = this.head.next;
            this.head.next = newHead;
            newHead.prev = this.head;
            cache.put(key, newHead);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] operations = scanner.nextLine().split(" ");
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        scanner.close();
        LRUCache lru = null;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            switch (operations[i]) {
                case "LRUCache":
                    lru = new LRUCache(arr[i][0]);
                    res[i] = "null";
                    break;
                case "get":
                    res[i] = Integer.toString(lru.get(arr[i][0]));
                    break;
                case "put":
                    lru.put(arr[i][0], arr[i][1]);
                    res[i] = "null";
                    break;
            }
        }
        System.out.println(String.join(" ", res));
    }
}