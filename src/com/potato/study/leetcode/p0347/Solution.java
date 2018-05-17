package com.potato.study.leetcode.p0347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *        347. Top K Frequent Elements
 * 
 *        Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *         
 *         
 *         
 *         思路：首先使用map 统计每个数字出现的次数
 *         然后对统计结果建立堆 小根堆 向堆中加入元素 一旦堆重元素数量超过k时， 删除堆的根节点  
 *        jdk 优先队列https://blog.csdn.net/congduan/article/details/45178337
 *        算法思路：
 *        https://blog.csdn.net/tstsugeg/article/details/51307441
 */
public class Solution {
	
	class Node{
		public int val;
		public int times;
		
		public Node(int val, int times) {
			this.val = val;
			this.times = times;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> timesMap = new HashMap<>();
		for(int ele : nums) {
			if(timesMap.containsKey(ele)) {
				timesMap.put(ele, timesMap.get(ele) + 1);
			} else {
				timesMap.put(ele, 1);
			}
		}
		// 遍历map 建立堆
		PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.times - o2.times;
			}
		});
		for(int key : timesMap.keySet()) {
			heap.add(new Node(key, timesMap.get(key)));
			if(heap.size() > k) {
				heap.remove();
			}
		}
		List<Integer> topList = new ArrayList<>();
		while(!heap.isEmpty()) {
			topList.add(heap.remove().val);
		}
		return topList; 
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int k = 2;
		int[] nums = {1,1,1,2,2,3};
		List<Integer> list = solution.topKFrequent(nums, k);
		System.out.println(list);
	}
	
	
}
