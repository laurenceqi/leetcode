import java.util.HashMap;

/**
 * Created by laurenceqi on 18/4/23.
 */

public class LRUCache {

    static class NodeRefer {
        Integer value;
        Node node;

        NodeRefer(Integer value, Node node) {
            this.value = value;
            this.node = node;
        }
    }

    static class Node {
        Integer key;
        Node pre;
        Node next;

        Node(Integer key) {
            this.key = key;
        }
    }

    private HashMap map = new HashMap<Integer, NodeRefer>();

    private int capacity;
    private Node lruHead = null;
    private Node lruEnd = null;
    private Integer size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        NodeRefer value = (NodeRefer) map.get(key);
        if (value == null) {
            return -1;
        }
        lruOldNode(value.node);
        return value.value;

    }

    public void put(int key, int value) {
        NodeRefer oldValue = (NodeRefer) map.get(key);
        if (oldValue == null) {
            Node node = new Node(key);
            insertNewHead(node);
            NodeRefer nodeRefer = new NodeRefer(value, node);
            map.put(key, nodeRefer);
        } else {
            Node oldNode = oldValue.node;
            lruOldNode(oldNode);
            oldValue.value = value;
        }
    }

    void insertNewHead(Node node) {
        if (lruHead == null) {
            lruHead = lruEnd = node;
        } else {
            lruHead.pre = node;
            node.next = lruHead;
            lruHead = node;
        }
        size++;

        if (size > capacity) {
            map.remove(lruEnd.key);
            lruEnd.pre.next = null;
            lruEnd = lruEnd.pre;
            size--;
        }
    }

    void lruOldNode(Node oldNode) {
        if (oldNode.pre == null) {
            //head node
            return;
        } else {
            oldNode.pre.next = oldNode.next;
            if (oldNode.next == null) {
                //end node
                lruEnd = oldNode.pre;
            } else {
                oldNode.next.pre = oldNode.pre;
            }

            lruHead.pre = oldNode;
            oldNode.next = lruHead;
            oldNode.pre = null;
            lruHead = oldNode;
        }
    }

    //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5, 5);
        System.out.println(cache.get(1));
        cache.get(2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




