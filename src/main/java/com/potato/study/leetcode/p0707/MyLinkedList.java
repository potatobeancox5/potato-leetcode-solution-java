package com.potato.study.leetcode.p0707;

/**
 * 
 * @author liuzhao11
 * 
 * 	707. Design Linked List
 *
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. If index is negative, the node will be inserted at the head of the list.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
Example:

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.
 *         
 *         题目解释：
 *
 *         
 *
 *
 * 
 */
public class MyLinkedList {

    private Node head;
    private int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = new Node();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= length || index < 0) {
            return -1;
        }
        Node p = head.next;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentIndex++;
            p = p.next;
        }
        if (currentIndex == index && p != null) {
            return p.val;
        }
        return -1;
    }

    private Node getNode(int index) {
        if (index >= length || index < 0) {
            return null;
        }
        Node p = head.next;
        int currentIndex = 0;
        while (currentIndex < index) {
            currentIndex++;
            p = p.next;
        }
        if (currentIndex == index && p != null) {
            return p;
        }
        return null;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node p = head.next;
        Node node = new Node();
        node.val = val;
        node.next = p;
        head.next = node;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        // 找到最后一个位置
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        Node node = new Node();
        node.val = val;
        p.next = node;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index == length) {
            addAtTail(val);
        } else if (index < length) {
            if (index == 0) {
                addAtHead(val);
            } else {
                // 找到位置
                Node pre = getNode(index - 1);
                Node p = pre.next;
                Node newNode = new Node();
                newNode.val = val;
                pre.next = newNode;
                newNode.next = p;
                length++;
            }
        } else {
            return;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node node = getNode(index - 1);
        node.next = node.next.next;
        length--;
    }

    class Node {
        public int val;
        public Node next;
    }


    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(-1, 0);
        myLinkedList.get(0);
        myLinkedList.deleteAtIndex(-1);

    }
}

