package com.potato.study.leetcode.p0460;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *        460. LFU Cache
 * 
 *       Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.



Follow up:
Could you do both operations in O(1) time complexity?



Example:

LFUCache cache = new LFUCache( 2  capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 * 
 * 
 *         思路： 
 *         460. LFU Cache

https://leetcode.com/problems/lfu-cache/discuss/407140/java-pq+hashmap-putget-o(n)-in-worst-case
node
key
val
frequ
timstamp

map 存key  value node 对象 便于get
堆 排序规则 freque 升序 stamp升序 方便清理

get
map 不存在 返回-1
map 存在 拿到node 创建新node freq+1              更新堆    返回val

put
map 中存在 更新val fre+1 pq删除 加入
map 中没有
创建node 加入map
检查是否超限 超了pq pop
pq add
 * 			
 * 				
 */	
public class LFUCache {

    private Map<Integer, Node> map;
    private PriorityQueue<Node> priorityQueue;
    private int capacity;
    private int timeStamp;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.frequency == o2.frequency) {
                    return o1.timeStamp >= o2.timeStamp ? 1 : -1;
                }
                return o1.frequency >= o2.frequency ? 1 : -1;
            }
        });
        this.capacity = capacity;
        this.timeStamp = 0;
    }

    public int get(int key) {
//        map 不存在 返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        ++timeStamp;
//        map 存在 拿到node 创建新node freq+1              更新堆    返回val
        Node node = map.get(key);
        Node newNode = new Node(node.key, node.value, node.frequency + 1, timeStamp);
        priorityQueue.remove(node);
        priorityQueue.add(newNode);

        map.put(key, newNode);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        ++timeStamp;
//        map 中存在 更新val fre+1 pq删除 加入
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node newNode = new Node(node.key, value, node.frequency + 1, timeStamp);
            priorityQueue.remove(node);
            priorityQueue.add(newNode);
            map.put(key, newNode);
        } else {
//        map 中没有
            Node node = new Node(key, value, 1, timeStamp);
            if (map.size() == capacity) {
//        检查是否超限 超了pq pop
                Node oldNode = priorityQueue.remove();
                map.remove(oldNode.key);
            }
//        pq add
            priorityQueue.add(node);
//        创建node 加入map
            map.put(node.key, node);
        }
    }

	class Node {
        public int key;
        public int value;
        public int frequency;
        public int timeStamp;

        public Node (int key, int value, int frequency, int timeStamp) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.timeStamp = timeStamp;
        }
    }


    public static void main(String[] args) {
//        ["LFUCache","put","put","put","put","get"]
//[[2],[3,1],[2,1],[2,2],[4,4],[2]]
        LFUCache cache = new LFUCache(2);
        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        int i = cache.get(2);
        System.out.println(i);


        cache = new LFUCache(0);
        cache.put(0,0);
        int res = cache.get(0);
        System.out.println(res);


        cache = new LFUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        i = cache.get(3);
        System.out.println(i);
        i = cache.get(2);
        System.out.println(i);
        i = cache.get(3);
        System.out.println(i);
        i = cache.get(4);
        System.out.println(i);
    }

}
