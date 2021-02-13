package com.potato.study.leetcodecn.p00622.t001;


/**
 * 622. 设计循环队列
 *
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。

 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

 你的实现应该支持如下操作：

 MyCircularQueue(k): 构造器，设置队列长度为 k 。
 Front: 从队首获取元素。如果队列为空，返回 -1 。
 Rear: 获取队尾元素。如果队列为空，返回 -1 。
 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 isEmpty(): 检查循环队列是否为空。
 isFull(): 检查循环队列是否已满。
  

 示例：

 MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 circularQueue.enQueue(1);  // 返回 true
 circularQueue.enQueue(2);  // 返回 true
 circularQueue.enQueue(3);  // 返回 true
 circularQueue.enQueue(4);  // 返回 false，队列已满
 circularQueue.Rear();  // 返回 3
 circularQueue.isFull();  // 返回 true
 circularQueue.deQueue();  // 返回 true
 circularQueue.enQueue(4);  // 返回 true
 circularQueue.Rear();  // 返回 4
  

 提示：

 所有的值都在 0 至 1000 的范围内；
 操作数将在 1 至 1000 的范围内；
 请不要使用内置的队列库。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/design-circular-queue
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MyCircularQueue {
    /**
     * 队列中 数组的带下吸纳之
     */
    private int len;
    /**
     * 下一个元素 pop的index
     */
    private int head;
    /**
     * 下一个元素 插入的index
     */
    private int tail;


    private int[] nums;

    /**
     * 设计大小为 k的循环队列
     * 那么最重要的一点就是 如何判断队列空和队列满
     * @param k
     */
    public MyCircularQueue(int k) {
        this.head = 0;
        this.tail = 0;
        // 需要一个位置 用来识别队列满
        this.len = k + 1;
        this.nums = new int[len];
    }

    /**
     * 向循环队列插入一个元素。如果成功插入则返回真。
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        // 是够满
        if (isFull()) {
            return false;
        }
        // 不满 插入
        nums[tail++] = value;
        tail %= len;
        return true;
    }

    /**
     * 从循环队列中删除一个元素。如果成功删除则返回真。
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        head %= len;
        return true;
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     * @return
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[head];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1 。
     * @return
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[(tail - 1 + len) % len];
    }

    /**
     * 队列空的判断条件
     * @return
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 队列满的判断条件
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % len == head;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1)); // 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4
    }
}
