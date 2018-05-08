package com.potato.study.leetcode.p0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *     225. Implement Stack using Queues
 * 
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and all test cases.	
 * *         
 * 思路： 用队列实现栈
 *  	两个队列 q1 q2
 *  push 向q1中 插入
 *  pop  
 *  	q1 中有值的话  将q1出队 入队q2 直到找到q1的最后一个值
 *  	q1没有的话 将q2 依次出队 入队q1 直到 找到q2的最后一个值
 *  	
 *  top  q1 中有值的话  将q1出队 入队q2 直到找到q1的最后一个值
 *  	q1没有的话 将q2 依次出队 入队q1 直到 找到q2的最后一个值
 *  empty q1 空 且 q2 空
 */
public class MyStack {
	
	private Queue<Integer> q1 = null;
	private Queue<Integer> q2 = null;
	
	/** Initialize your data structure here. */
    public MyStack() {
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(!q1.isEmpty()) {
        	while(!q1.isEmpty()) {        		
        		int val = q1.remove();
        		if(q1.isEmpty()) {
        			return val;
        		}
        		q2.add(val);
        	}
        } else {
        	while(!q2.isEmpty()) {        		
        		int val = q2.remove();
        		if(q2.isEmpty()) {
        			return val;
        		}
        		q1.add(val);
        	}
        }
        return -1;
    }
    
    /** Get the top element. */
    public int top() {
        if(!q1.isEmpty()) {
        	while(!q1.isEmpty()) {        		
        		int val = q1.remove();
        		if(q1.isEmpty()) {
        			q2.add(val);
        			return val;
        		}
        		q2.add(val);
        	}
        } else {
        	while(!q2.isEmpty()) {        		
        		int val = q2.remove();
        		if(q2.isEmpty()) {
        			q1.add(val);
        			return val;
        		}
        		q1.add(val);
        	}
        }
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
