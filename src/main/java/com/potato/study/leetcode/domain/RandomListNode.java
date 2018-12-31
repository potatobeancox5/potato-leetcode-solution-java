package com.potato.study.leetcode.domain;

/**
 * 随机链表节点
 * 
 * @author liuzhao11
 *
 */
public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}
}
