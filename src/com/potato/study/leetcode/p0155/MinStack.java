package com.potato.study.leetcode.p0155;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      155. Min Stack
 *         
 *          
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 *
 *         题目需求：
 *			提供一个能输出最小值的栈
 *         思路：
 *         	必须能够记录每个出战元素出栈时的最小值
 *         	设置一个新的栈 minStack 用来记录当前位置的最小值
 *         	minStack 空时 stack push ,minStack push
 *         	不空时stack push 与 minStack 栈顶比较 小于minStack栈顶时  minStack push
 *         	pop时 与minStack栈顶比较 pop的值等于 minStack栈顶 则 minStack 出战
 *
 *
 *
 */
public class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;


	/** initialize your data structure here. */
	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int x) {
		if(stack.isEmpty()) {
			stack.push(x);
			minStack.push(x);
		} else {
			stack.push(x);
			if(minStack.isEmpty()) {
				minStack.push(x);
			} else {
				if(minStack.peek() >= x) {
					minStack.push(x);
				}
			}
		}
	}

	public void pop() {
		if(stack.isEmpty()) {
			return;
		}
		int value = stack.pop();
		if(!minStack.isEmpty() && minStack.peek() == value) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
