/**
 *Problem: 146. LRU Cache
 *Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *Implement the LRUCache class:
 *LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *The functions get and put must each run in O(1) average time complexity.
 */

class LRUCache {
    //LRU: Least Recently Used
    //Maintain a fixed-size cache of key-value pairs using a doubly linked list and an unordered map.
    //When accessing or adding a key-value pair, it moves the corresponding node to the front of the linked list, making it the most recently used item. This way, the least recently used item is always at the end of the list. When the cache is full and a new item is added, it removes the item at the end of the list (least recently used) to make space for the new item, ensuring the LRU property is maintained.
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();


    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;    
    }

    private void addNode(Node newnode){
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void deleteNode(Node delnode){
        Node prevv = delnode.prev;
        Node nextt = delnode.next;

        prevv.next = nextt;
        nextt.prev = prevv;
    }

    public int get(int key) {
        if(m.containsKey(key)){
            Node resNode = m.get(key);
            int ans = resNode.val;

            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            m.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }

        if(m.size() == cap){
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        addNode(new Node(key,value));
        m.put(key, head.next);   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


