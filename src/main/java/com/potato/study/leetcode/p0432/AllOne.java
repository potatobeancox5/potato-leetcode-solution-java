package com.potato.study.leetcode.p0432;


import java.util.*;

/**
 * 
 * @author liuzhao11
 * 
 *   432. All O`one Data Structure
 * 
 *   Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.

 * 			
 *     思路：
 *
 *     两个map
 *     一个map记录从 key-String 出现的次数
 *     另一个map 记录 次数 -> 这个次数出现的node有那些
 *     https://blog.csdn.net/katrina95/article/details/101277522
 *
 *     https://leetcode.com/problems/all-oone-data-structure/discuss/91416
 *
 *     首先定义一个数据结构 Bucket    ， Bucket 维护出现同样次数的 keys 记录 count 出现次数 next prev 往后越大 往前越小
 *
 *     
 * 			
 * 	
 */	
public class AllOne {

	/**
	 * 保存出现同一个次数的key
	 */
	class Bucket {
		// key 出现的次数
		public int count;
		// 同一个次数的keys 集合
		public Set<String> keys;
		// 前后桶指针 前边那个比他多，后边那个比他小
		public Bucket next;
		public Bucket prev;

		public Bucket() {
		}

		public Bucket(int count) {
			this.count = count;
			keys = new HashSet<>();
		}


	}

	// 一个key 出现次数的map
	private Map<String, Integer> key2CountMap;
	// 出现 count次 的首个桶在哪
	private Map<Integer, Bucket> count2BucketMap;
	// 最小的桶
	private Bucket headFist;
	// 最大的桶
	private Bucket tailLast;

	/** Initialize your data structure here. */
	public AllOne() {
		key2CountMap = new HashMap<>();
		count2BucketMap = new HashMap<>();
		headFist = new Bucket(Integer.MIN_VALUE);
		tailLast = new Bucket(Integer.MAX_VALUE);

		headFist.next = tailLast;
		tailLast.prev = headFist;
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		// 1. key2CountMap 增加次数
		if (key2CountMap.containsKey(key)) {
			changeKey(key, 1);
		} else {
			// key2CountMap 中没有这个值
			key2CountMap.put(key, 1);
			if (headFist.next.count != 1) {
				// 需要添加一个了
				addBucketAfter(new Bucket(1), headFist);
			}
			headFist.next.keys.add(key);
			count2BucketMap.put(1, headFist.next);
		}
		// 2. 更换 key 在 count2BucketMap 的位置

		// 3. 更改 head 或者tail 位置
	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if (key2CountMap.containsKey(key)) {
			int count = key2CountMap.get(key);
			if (count == 1) {
				key2CountMap.remove(key);
				removeKeyFromBucket(count2BucketMap.get(count), key);
			} else {
				changeKey(key, -1);
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		// tail pre 的值
		if (tailLast.prev == headFist) {
			return "";
		}
		if (tailLast.prev.keys.size() == 0) {
			return "";
		}
		String res = tailLast.prev.keys.iterator().next();
		return res;
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		// head next 的值
		if (headFist.next == tailLast) {
			return "";
		}
		if (headFist.next.keys.size() == 0) {
			return "";
		}
		String res = headFist.next.keys.iterator().next();
		return res;
	}


	// key + 1 或者 key -1
	private void changeKey(String key, int offset) {
		// 获取当前key 对应的count
		int count = key2CountMap.get(key);
		key2CountMap.put(key, count + offset);
		// 更改 key 在 bucket中的位置 之后被删除
		Bucket curBucket = count2BucketMap.get(count);
		Bucket newBucket;
		if (count2BucketMap.containsKey(count + offset)) {
			// target Bucket already exists
			newBucket = count2BucketMap.get(count + offset);
		} else {
			// add new Bucket
			newBucket = new Bucket(count + offset);
			count2BucketMap.put(count + offset, newBucket);
			addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
		}
		newBucket.keys.add(key);
		removeKeyFromBucket(curBucket, key);
	}


	/**
	 * 向 prevBucket 后添加 newBucket
	 * @param newBucket
	 * @param prevBucket
	 */
	public void addBucketAfter(Bucket newBucket, Bucket prevBucket) {
		newBucket.prev = prevBucket;
		newBucket.next = prevBucket.next;
		prevBucket.next.prev = newBucket;
		prevBucket.next = newBucket;
	}

	/**
	 * 从 Bucket中 删除 bucket
	 * @param bucket
	 */
	public void removeBucketFromList(Bucket bucket) {
		bucket.prev.next = bucket.next;
		bucket.next.prev = bucket.prev;
		bucket.next = null;
		bucket.prev = null;
	}

	/**
	 * 从桶中 删除key
	 * @param bucket
	 * @param key
	 */
	public void removeKeyFromBucket(Bucket bucket, String key) {
		bucket.keys.remove(key);
		if (bucket.keys.size() == 0) {
			removeBucketFromList(bucket);
			count2BucketMap.remove(bucket.count);
		}
	}

	public static void main(String[] args) {
		AllOne allOne = new AllOne();
		allOne.getMaxKey();
	}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */