package com.potato.study.leetcode.p0430;

/**
 * 
 * @author liuzhao11
 * 
 *   430. Flatten a Multilevel Doubly Linked List
 * 
 *   You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.



Example:

Input:
1---2---3---4---5---6--NULL
|
7---8---9---10--NULL
|
11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL


Explanation for the above example:

Given the following multilevel doubly linked list:




We should return the following flattened doubly linked list:



 * 			
 *     思路：
 *     https://www.liangzl.com/get-article-detail-28987.html
 *
 *
 *     对于每一个点 如果它有孩子节点 那么将它的next改成孩子节点
 *     
 * 			
 * 	
 */	
public class Solution {

	public Node flatten(Node head) {
		Node headFirst = new Node();
		this.doFlattenForCurrentNode(headFirst, head);
		Node result = headFirst.next;
		if (result != null) {
			result.prev = null;
		}
		return result;
	}


	/**
	 *
	 * @param flattenNode 被铺平的节点结合 （最终返回结果，最后一个节点）
	 * @param head 当前需要进行处理的节点
	 * @return 下一个需要进行连接的点
	 */
	private Node doFlattenForCurrentNode(Node flattenNode, Node head) {
		// 0. 当前没有需要进行遍历的节点 返回 flattenNode
		if (null == head) {
			return flattenNode;
		}
		// 1. 打平当前的点 放进去flattenNode
		flattenNode.next = head;
		head.prev = flattenNode;
		// 2. 记录没有处理的点 也就是 flattenNode 点的next
		Node flattenNodeNext = flattenNode.next;
		Node headNext = head.next;
		// 3. 如果head的 child还存在，那么需要先处理child
		if (null != head.child) {
			flattenNodeNext = doFlattenForCurrentNode(flattenNodeNext, head.child);
			head.child = null;
		}
		// 4. 返回当前没有进行处理的点
		return doFlattenForCurrentNode(flattenNodeNext, headNext);
	}


	
	
	
	
	public static void main(String[] args) {
	}
}


class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node() {}

	public Node(int val,Node prev,Node next,Node child) {
		this.val = val;
		this.prev = prev;
		this.next = next;
		this.child = child;
	}
};