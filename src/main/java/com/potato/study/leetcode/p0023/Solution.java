package com.potato.study.leetcode.p0023;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 * 
 * 思路 ： 
 * 开一个堆结构k个大小 用于比较当前 k 个有序队列的最小值
 * 小根堆
 * 初始 拿出k个链表的头 建立堆
 * 循环 删除堆顶 并将堆顶元素的下一个 放在堆顶 然后进行调整
 * 				若果堆顶元素 没有下一个元素 则将最后一个元素放在堆中 然后调整 并且缩减实际堆的大小
 * 使用java 提供的优先队列 自己实现一下优先队列
 * 
 * 
 */
public class Solution {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(-1);
		if (null == lists || lists.length == 0) {
			return head.next;
		}
		ListNode p = head;
		PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
			/**
			 * 确定如何排序
			 */
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode[] currents = lists;
		//建堆
		for (ListNode listNode : currents) {
			if (listNode != null) {
				heap.add(listNode);
			}
		}
		// 循环删除堆顶并调整堆接口
		while (!heap.isEmpty()) {
			p.next = heap.poll();
			p = p.next;
			if (p.next != null) { // 加入新的元素
				heap.add(p.next);
			}
		}
		return head.next;
	}

	/**
	 * 递归调整堆 使得堆成为一个小跟对
	 * 
	 * @param heap
	 * @param heapSize
	 */
//	private void arrangeHeap(ListNode[] heap, int heapSize) {
//		for (int i = 0; i < heapSize; i++) {
//			// parent:i left-child: 2 * i + 1 right 2 * (i+1)
//			if (2 * (i + 1) >= heapSize && 2 * i + 1 >= heapSize) { // 走到根结点了 可以推出循环
//				break;
//			} else if (2 * (i + 1) < heapSize) {
//				if (heap[2 * i + 1].val < heap[2 * (i + 1)].val) {// root <==> left child
//					if (heap[i].val > heap[2 * i + 1].val) {
//						ListNode tmp = heap[i];
//						heap[i] = heap[2 * i + 1];
//						heap[2 * i + 1] = tmp;
//					}
//				} else { // root <==> right child
//					if (heap[i].val > heap[2 * (i + 1)].val) {
//						ListNode tmp = heap[i];
//						heap[i] = heap[2 * (i + 1)];
//						heap[2 * (i + 1)] = tmp;
//					}
//				}
//			} else if (2 * (i + 1) > heapSize && 2 * i + 1 < heapSize) {
//				if (heap[i].val > heap[2 * i + 1].val) {
//					ListNode tmp = heap[i];
//					heap[i] = heap[2 * i + 1];
//					heap[2 * i + 1] = tmp;
//				}
//			}
//		}
//	}

	/**
	 * 建立堆
	 * @param heap
	 * @param size
	 */
//	private void buildHeap(ListNode[] heap, int size) {
//		int index = size - 1;
//		while() {
//		}
//	}

	public static void main(String[] args) {
//		Solution solution = new Solution();

	}
}
