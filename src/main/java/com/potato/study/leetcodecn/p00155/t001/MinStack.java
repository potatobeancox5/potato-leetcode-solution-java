package com.potato.study.leetcodecn.p00155.t001;

import java.util.Stack;

/**
 * 155. 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) —— 将元素 x 推入栈中。
 pop() —— 删除栈顶的元素。
 top() —— 获取栈顶元素。
 getMin() —— 检索栈中的最小元素。
  

 示例:

 输入：
 ["MinStack","push","push","push","getMin","pop","top","getMin"]
 [[],[-2],[0],[-3],[],[],[],[]]

 输出：
 [null,null,null,null,-3,null,0,-2]

 解释：
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.
  

 提示：

 pop、top 和 getMin 操作总是在 非空栈 上调用。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/min-stack
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {


    private Stack<MinStackNode> stack;
    private MinStackNode head;

    /**
     * 内部数据结构是个栈，但是栈的元素之间维护一个 最小指针，head 永远指向最小的节点
     * 调用方保证 非空
     */
    public MinStack() {
        this.stack = new Stack<>();
        head = new MinStackNode(null, -1);
    }

    /**
     * 插入元素，并比较 插入最小链表
     * @param x
     */
    public void push(int x) {
        MinStackNode node = new MinStackNode(null, x);
        stack.push(node);
        this.addNode2List(node, head);
    }

    /**
     * 往 带节点的 升序链表中 插入元素
     * @param node
     * @param head
     */
    private void addNode2List(MinStackNode node, MinStackNode head) {
        if (head.next == null) {
            head.next = node;
            return;
        }
        MinStackNode pre = head;
        MinStackNode pp = head.next;
        // 找到插入位置 pp
        while (pp != null && pp.val <= node.val) {
            pp = pp.next;
            pre = pre.next;
        }
        if (pp == null) {
            pre.next = node;
            return;
        }
        // 插入pp和pre之间
        node.next = pp;
        pre.next = node;
        return;
    }

    /**
     * 删除元素，并修改元素之间的指针
     */
    public void pop() {
        MinStackNode node = stack.pop();
        this.delNodeFromList(node, head);
    }

    /**
     * 从 升序 链表中 删除 元素 node
     * @param node
     * @param head
     */
    private void delNodeFromList(MinStackNode node, MinStackNode head) {
        if (head.next == null) {
            return;
        }
        MinStackNode pre = head;
        MinStackNode pp = head.next;
        while (null != pp) {
            // 发现需要删除的节点
            if (pp == node) {
                pre.next = pp.next;
                break;
            }
            pp = pp.next;
            pre = pre.next;
        }
    }

    /**
     * 直接peek 即可
     * @return
     */
    public int top() {
        return stack.peek().val;
    }

    /**
     * 返回 head 指向的元素
     * @return
     */
    public int getMin() {
        return head.next.val;
    }

    class MinStackNode {
        /**
         * 下一个元素，一般是只比元素大一点的元素
         */
        public MinStackNode next;
        /**
         * 当前元素的值
         */
        public int val;

        public MinStackNode(MinStackNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }
}
