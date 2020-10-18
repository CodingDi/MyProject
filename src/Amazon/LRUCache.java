package Amazon;
import java.util.*;
public class LRUCache {

        class DListNode {
            int key;
            int value;
            DListNode prev;
            DListNode next;
            DListNode () {}
            DListNode (int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private int capacity;
        private Map<Integer, DListNode> cache;
        private DListNode head;
        private DListNode tail;

        public LRUCache(int capacity) {

            this.size = 0;
            this.capacity = capacity;
            cache = new HashMap<>();

            head = new DListNode();
            tail = new DListNode();
            head.next = tail;
            tail.prev = head;
        }



        public int get(int key) {
            // if key exists, update the value in cache and move it to the head
            // if not exist, return -1
            DListNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            // if the key exists, update from cache and lsit, mode to the head
            // if not exist, create a new one and add to the cache and head
            //     if cache is full, remove the tail from list and cache

            DListNode node = cache.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                DListNode newNode = new DListNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;

                if (capacity < size) {
                    DListNode lastNode = tail.prev;
                    removeNode(lastNode);
                    cache.remove(lastNode.key);
                    size--;
                }
            }
        }



        //add node to the head in the DList and cache

        private void addToHead(DListNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        //remove the current node from the DList and cache
        private void removeNode(DListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        //remove the tail of the DLisy and cache
        private DListNode removeTail() {
            // remove the node before tail, also update cache
            DListNode lastNode = tail.prev;
            removeNode(lastNode);
            cache.remove(lastNode.key);//remove from cache
            return lastNode;
        }

        //move the given node to the head
        private void moveToHead(DListNode node) {
            // remove the given node,
            removeNode(node);
            // add the node to the head
            addToHead(node);
        }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
