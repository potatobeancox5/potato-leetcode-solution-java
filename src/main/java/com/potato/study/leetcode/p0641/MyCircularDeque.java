package com.potato.study.leetcode.p0641;



/**
 * 
 * @author liuzhao11
 * 
 *         641. Design Circular Deque
 * 
 *        Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not.
isFull(): Checks whether Deque is full or not.


Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4


Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Deque library.
 * 
 *         思路：
 *         641. Design Circular Deque

自定义双端队列

https://blog.csdn.net/u013383813/article/details/85242768

数据结构

链表节点
node

public node next， prev

public int value


int size ；// 总大小
int capacity ；//

Node head
Node tail



Insert 先判断是不是 满

Delete 先判断是不是空

 *
 *
 */
public class MyCircularDeque {

    // 当前容量
    private int size;

    // 总大小
    private int capacity;

    // 头节点
    private Node head;

    // 尾节点
    private Node tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        size = 0;
        capacity = k;
        head.next = tail;
        tail.prev = head;

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        size++;

        Node first = head.next;
        Node target = new Node(value);
        target.next = first;
        first.prev = target;
        head.next = target;
        target.prev = head;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        size++;
        Node last = tail.prev;
        Node target = new Node(value);
        last.next = target;
        target.prev = last;
        tail.prev = target;
        target.next = tail;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size--;
        Node newFirst = head.next.next;
        head.next = newFirst;
        newFirst.prev = head;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;
        Node newTail = tail.prev.prev;
        tail.prev = newTail;
        newTail.next = tail;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (size == capacity) {
            return true;
        }
        return false;
    }

    /**
     * 节点 定义
     */
    class Node {
        public Node next;
        public Node prev;
        public int value;

        public Node (int value) {
            this.value = value;
        }
    }
}
