package com.potato.study.leetcode.p0232;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *      232. Implement Queue using Stacks
 * 
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * 
 * 思路： 设置两个栈 push 直接放入栈1
 * 		pop 检查栈2是否为空    非空 直接栈2pop 空 将 栈1 依次出栈 然后进栈2  最后pop 栈2
 * 		peak 与pop相似
 * 		
 *  
 */
public class MyQueue {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
    /** Initialize your data structure here. */
    public MyQueue() {
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack2.isEmpty()) {
        	return stack2.pop();
        } else {
        	while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        	return stack2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
    	if(!stack2.isEmpty()) {
        	return stack2.peek();
        } else {
        	while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
        	return stack2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
