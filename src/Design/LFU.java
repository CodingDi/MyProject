package Design;

import java.util.HashMap;
import java.util.Map;

public class LFU {




    class LFUCache {

        Map<Integer, Node> cache;
// 存储缓存的内容，Node中除了value值外，还有key、freq、所在doublyLinkedList、所在doublyLinkedList中的postNode、所在doublyLinkedList中的preNode，具体定义在下方。

        DLinkedList max; // firstLinkedList.post 是频次最大的双向链表
        DLinkedList min;
// lastLinkedList.pre 是频次最小的双向链表，满了之后删除 lastLinkedList.pre.tail.pre
        //这个Node即为频次最小且访问最早的Node

        int size;
        int capacity;



        public LFUCache(int capacity) {
            cache = new HashMap<>(capacity);

            max = new DLinkedList();
            min = new DLinkedList();

            max.next = min;
            min.prev = max;

            this.capacity = capacity;

        }



        public int get(int key) {

            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }

            // 该key访问频次+1

            freqInc(node);

            return node.value;

        }



        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node node = cache.get(key);
            // 若key存在，则更新value，访问频次+1
            if (node != null) {

                node.value = value;
                freqInc(node);

            } else {

                // 若key不存在

                if (size == capacity) {
                    // 如果缓存满了，删除lastLinkedList.pre这个链表（即表示最小频次的链表）中的tail.pre这个Node（即最小频次链表中最先访问的Node），如果该链表中的元素删空了，则删掉该链表。

                    cache.remove(min.prev.tail.prev.key);
                    min.removeNode(min.prev.tail.prev);

                    size--;

                    if (min.prev.head.next == min.prev.tail) {

                        removeList(min.prev);

                    }

                }

                // cache中put新Key-Node对儿，并将新node加入表示freq为1的DoublyLinkedList中，若不存在freq为1的DoublyLinkedList则新建。

                Node newNode = new Node(key, value);
                cache.put(key, newNode);

                if (min.prev.freq != 1) {

                    DLinkedList newList = new DLinkedList(1);
                    addList(newList, min.prev);
                    newList.addNode(newNode);

                } else {
                    min.prev.addNode(newNode);
                }
                size++;

            }

        }


        /**
         * node的访问频次 + 1
         */
        void freqInc(Node node) {

            // 将node从原freq对应的双向链表里移除, 如果链表空了则删除链表。

            DLinkedList linkedList = node.list;
            DLinkedList preLinkedList = linkedList.prev;

            linkedList.removeNode(node);

            if (linkedList.head.next == linkedList.tail) {
                removeList(linkedList);

            }


            // 将node加入新freq对应的双向链表，若该链表不存在，则先创建该链表。

            node.freq++;

            if (preLinkedList.freq != node.freq) {

                DLinkedList newList = new DLinkedList(node.freq);
                addList(newList, preLinkedList);

                newList.addNode(node);

            } else {

                preLinkedList.addNode(node);

            }

        }


        /**
         * 增加代表某1频次的双向链表
         */
        void addList(DLinkedList newList, DLinkedList preLinkedList) {

            newList.next = preLinkedList.next;
            newList.next.prev = newList;

            newList.prev = preLinkedList;
            preLinkedList.next = newList;

        }


        /**
         * 删除代表某1频次的双向链表
         */
        void removeList(DLinkedList list) {

            list.prev.next = list.next;
            list.next.prev = list.prev;

        }

    }



    class Node {

        int key;
        int value;
        int freq = 1;

        Node prev; // Node所在频次的双向链表的前继Node
        Node next; // Node所在频次的双向链表的后继Node

        DLinkedList list;  // Node所在频次的双向链表

        public Node() {}

        public Node(int key, int value) {

            this.key = key;
            this.value = value;

        }

    }



    class DLinkedList {

        int freq; // 该双向链表表示的频次

        DLinkedList prev;  // 该双向链表的前继链表（pre.freq < this.freq）
        DLinkedList next; // 该双向链表的后继链表 (post.freq > this.freq)

        Node head; // 该双向链表的头节点，新节点从头部加入，表示最近访问
        Node tail; // 该双向链表的尾节点，删除节点从尾部删除，表示最久访问



        public DLinkedList() {
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;

        }



        public DLinkedList(int freq) {

            head = new Node();

            tail = new Node();

            head.next = tail;

            tail.prev = head;

            this.freq = freq;

        }



        void removeNode(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

        }


        void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;

            node.list = this;

        }

    }



}
