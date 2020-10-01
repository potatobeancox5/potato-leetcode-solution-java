package com.potato.study.leetcodecn.p0707.t001;

import org.junit.Assert;

/**
 * 707. 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

 在链表类中实现这些功能：

 get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
  

 示例：

 MyLinkedList linkedList = new MyLinkedList();
 linkedList.addAtHead(1);
 linkedList.addAtTail(3);
 linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 linkedList.get(1);            //返回2
 linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 linkedList.get(1);            //返回3
  

 提示：

 所有val值都在 [1, 1000] 之内。
 操作次数将在  [1, 1000] 之内。
 请不要使用内置的 LinkedList 库。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/design-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MyLinkedList {

    class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 指向头节点 (head.next = 真实头部)
     */
    private Node head;

    /**
     * 指向尾节点 （tail.next = null）
     */
    private Node tail;

    private int length;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new Node(-1, null);
        this.tail = head;
        this.length = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int cur = 0;
        Node p = head.next;
        while (p != null && cur < index) {
            p = p.next;
            cur++;
        }
        if (p == null) {
            return -1;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val, null);
        if (head.next != null) {
            node.next = head.next;
        }
        head.next = node;
        length++;
        if (tail == head) {
            tail = node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val, null);
        tail.next = node;
        tail = tail.next;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index <= 0){
            addAtHead(val);
        } else {
            // 正常情况
            int cur = 0;
            Node p = head.next;
            Node q = head;
            while (p != null && cur < index) {
                p = p.next;
                q = q.next;
                cur++;
            }
            q.next = new Node(val, p);
            /**
             * 达到末尾
             */
            if (q == tail) {
                tail = q.next;
            }
        }
        length++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int cur = 0;
        Node p = head.next;
        Node q = head;
        while (p != null && cur < index) {
            p = p.next;
            q = q.next;
            cur++;
        }
        if (p == null) {
            return;
        }
        q.next = p.next;
        /**
         * 修改尾指针
         */
        if (p == tail) {
            tail = q;
        }
    }


    public static void main(String[] args) {
//        ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
          //[[],            [1],          [3],         [1,2],    [1],   [1],          [1]]

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);// 1
        myLinkedList.addAtTail(3);// 3
        myLinkedList.addAtIndex(1,2);
        // 1,2,3
        int res1 = myLinkedList.get(1);
        Assert.assertEquals(2, res1);
        myLinkedList.deleteAtIndex(1);
        int res2 = myLinkedList.get(1);
        Assert.assertEquals(3, res2);


//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//         [[],             [7],         [2],       [1],         [3,0],      [2],            [6],         [4],      [4],    [4],       [5,0],       [6]]


        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addAtHead(7);// 7
        myLinkedList1.addAtHead(2);// 2,7
        myLinkedList1.addAtHead(1);// 1,2,7
        myLinkedList1.addAtIndex(3,0);
        myLinkedList1.deleteAtIndex(2);//
        myLinkedList1.addAtHead(6);//
        myLinkedList1.addAtTail(4);//
        res1 = myLinkedList1.get(4);
        myLinkedList1.addAtHead(4);//
        myLinkedList1.addAtIndex(5,0);
        myLinkedList1.addAtHead(6);//



        // 1,2,3
        Assert.assertEquals(2, res1);
        myLinkedList1.deleteAtIndex(1);
        res2 = myLinkedList1.get(1);
        Assert.assertEquals(3, res2);

    }
}

/**
 * 单向链表实现，因为没有什么操作是要往前的
 * 牺牲封装性，为了算法书写方便
 */


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
