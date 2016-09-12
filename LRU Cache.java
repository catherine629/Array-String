// Method 1 - LinkedHashMap
class LRUCache1 {
  
    final int capacity;
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>((int)Math.ceil(capacity / 0.75f) + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
       map.put(key, value);
    }
}

// Method2: HashMap + Double LinkedList
class LRUCache2 {
    
    // double linked list
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        Node n = null;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.value = value;
            remove(n);
        } else {
            n = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key, n);
        }
        setHead(n);
    }
    
    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            // n is head
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            // n is tail
            tail = n.pre;   
        }
    }
    
    private void setHead(Node n) {
        if (n == head) {
            return;
        } else {
            n.pre = null;
            n.next = head;
            // link original head's pre to current head
            if (head != null) {
                head.pre = n;
            }
            head = n;
            // first add ele
            if (tail == null) {
                tail = head;
            }
        }
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
