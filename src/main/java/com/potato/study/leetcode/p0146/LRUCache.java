package com.potato.study.leetcode.p0146;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         146. LRU Cache
 *         
 *          
 *     Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity  );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4


 *
 *         题目需求：
 *
 *         思路：
 *
 *         
 *
 *         
 * 
 */
public class LRUCache {

	private int capacity;// 记录容量
	private int currentCapacity;// 目前已经保存的数量
	private Map<Integer, LRUCacheNode> map;// 保存结果
	private LRUCacheNode head; // 指向最开始的节点
	private LRUCacheNode tail; // 指向最近访问的那个节点

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key) {
		if (capacity == 0) {
			return -1;
		}
		if (currentCapacity == 0) {
			return -1;
		}
		if(!map.containsKey(key)) {
			return -1;
		}
		if (currentCapacity == 1) {
			return map.get(key).value;
		}
		// 取值
		LRUCacheNode toEditNode = map.get(key);
		if(head == toEditNode) {
			head = head.next;
			head.pre = null;
		}
		// 将本次访问的节点 放到tail后
		if (tail == toEditNode) {
			return map.get(key).value;
		}
		// 修改之前的关系
		LRUCacheNode preNode = toEditNode.pre;
		LRUCacheNode nextNode = toEditNode.next;
		if (preNode != null) {
			preNode.next = nextNode;
		}
		if (nextNode != null) {
			nextNode.pre = preNode;
		}
		tail.next = toEditNode;
		toEditNode.pre = tail;
		tail = tail.next;
		return toEditNode.value;
	}

	public void put(int key, int value) {
		if(currentCapacity == 0) { // 插入第一个节点的时候的处理
			LRUCacheNode newNode = new LRUCacheNode();
			newNode.key = key;
			newNode.value = value;
			map.put(key, newNode);
			head = newNode;
			tail = newNode;
			currentCapacity ++;
		} else {
			if(map.containsKey(key)) {
				// 存在的话 改变值 并改变关系
				LRUCacheNode toEditNode = map.get(key);
				// 修改head 一个节点的时候 不必修改
				if(head == toEditNode && currentCapacity != 1) {
					head = head.next;
				}
				if(tail == toEditNode) {
					toEditNode.value = value;
					return;
				}
				// 修改之前的关系
				LRUCacheNode preNode = toEditNode.pre;
				LRUCacheNode nextNode = toEditNode.next;
				if (preNode != null) {
					preNode.next = nextNode;
				}
				if (nextNode != null) {
					nextNode.pre = preNode;
				}
				// insertNodeToTail
				LRUCacheNode newNode = insertNodeToTail(key, value);
				if(head == toEditNode && currentCapacity == 1) {
					head = newNode;
				}
			} else { // 不存在 直接插入tail
				insertNodeToTail(key, value);
				currentCapacity ++;
			}
		}
		// 值达到上线的时候 删除head指向节点 并重新改变head指向
		if(currentCapacity > capacity) { // 只有 currentCapacity == 0时才会出现
			// 删除head
			int headKey = head.key;
			head = head.next;
			head.pre.next = null; // 释放节点
			head.pre = null;
			map.remove(headKey);
			currentCapacity--;
		}
	}

	private LRUCacheNode insertNodeToTail(int key, int value) {
		LRUCacheNode newNode = new LRUCacheNode();
		newNode.key = key;
		newNode.value = value;
		map.put(key, newNode);
		tail.next = newNode;
		newNode.pre = tail;
		tail = tail.next;
		return newNode;
	}

	/**
	 * LRUCacheNode 节点类
	 */
	class LRUCacheNode {
		public int key;
		public int value;
		public LRUCacheNode pre; // 前驱
		public LRUCacheNode next; // 后继
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		cache.put(2, 1);
		cache.put(3, 2);
		System.out.println(cache.get(3)); // 2
		System.out.println(cache.get(2)); // 1
		cache.put(4, 3);
		System.out.println(cache.get(2));       // returns 1
		System.out.println(cache.get(3));       // returns -1
		System.out.println(cache.get(4));       // returns 3
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
