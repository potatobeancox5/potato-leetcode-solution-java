package com.potato.study.leetcodecn.p01206.t001;


/**
 * 1206. 设计跳表
 *
 * 不使用任何库函数，设计一个跳表。

 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。

 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：


 Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。

 在本题中，你的设计应该要包含这些函数：

 bool search(int target) : 返回target是否存在于跳表中。
 void add(int num): 插入一个元素到跳表。
 bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 了解更多 : https://en.wikipedia.org/wiki/Skip_list

 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。

 样例:

 Skiplist skiplist = new Skiplist();

 skiplist.add(1);
 skiplist.add(2);
 skiplist.add(3);
 skiplist.search(0);   // 返回 false
 skiplist.add(4);
 skiplist.search(1);   // 返回 true
 skiplist.erase(0);    // 返回 false，0 不在跳表中
 skiplist.erase(1);    // 返回 true
 skiplist.search(1);   // 返回 false，1 已被擦除
 约束条件:

 0 <= num, target <= 20000
 最多调用 50000 次 search, add, 以及 erase操作。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/design-skiplist
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Skiplist {

    private SkiplistNode start;

    /**
     * 首先就是跳表的数据结构
     * 存储数据的链接表和索引
     *
     */
    public Skiplist() {
    }

    /**
     * 查找
     * @param target
     * @return
     */
    public boolean search(int target) {
        return this.searchNode(target) != null;
    }

    /**
     * 查找节点
     * @param target
     * @return
     */
    private SkiplistNode searchNode(int target) {
        if (isEmpty()) {
            return null;
        }
        // 当前节点 ，初始是 start，循环遍历下一个节点
        SkiplistNode node = start;
        while (node != null) {
            // 1. 找到了 当前节点
            if (node.value == target) {
                return node;
            }
            // 2. 当前节点值 大于 target 就是不存在
            if (node.value > target) {
                return null;
            }
            // 3. 当前节点值 小于 target 决定是往后 还是往下
            SkiplistNode next = node;
            // 3.1 如果有next 且 大于 next 还是得往右
            if (null != next && next.value <= target) {
                node = next;
                continue;
            }
            // 3.2 如果没有 next 或者 小于 next 往下找
            node = node.down;
        }
        return null;
    }

    /**
     * 需要有一个添加索引的过程
     * @param num
     */
    public void add(int num) {
//        if (isEmpty()) {
//            start = new SkiplistNode(null, null, num);
//            return ;
//        }
//        // 先找到最低级别列表
//        SkiplistNode node = start;
//        while (node != null) {
//            // 1. 找到了 当前节点
//            if (node.value == num) {
//                if (node.down != null) {
//                    node = node.down;
//                } else {
//                    break;
//                }
//            }
//            // 2. 当前节点值 大于 target 就是不存在
//            if (node.value > target) {
//                return null;
//            }
//            // 3. 当前节点值 小于 target 决定是往后 还是往下
//            SkiplistNode next = node;
//            // 3.1 如果有next 且 大于 next 还是得往右
//            if (null != next && next.value <= target) {
//                node = next;
//                continue;
//            }
//            // 3.2 如果没有 next 或者 小于 next 往下找
//            node = node.down;
//        }

        return ;
    }

    /**
     * 找到这个节点
     * @param num
     * @return
     */
    public boolean erase(int num) {
        SkiplistNode node = this.searchNode(num);
        if (node == null) {
            return false;
        }
        if (node.down == null) {
            // 判断 如果不是索引如何删除
            SkiplistNode pre = node.prev;
            pre.next = node.next;
        } else {
            // 判断 如果是索引 node 如何删除
            SkiplistNode down = node.down;
            do {
                SkiplistNode pre = node.prev;
                pre.next = node.next;
                node = down;
                down = node.down;
            } while (down != null);
        }
        return true;
    }

    private boolean isEmpty () {
        return null == start;
    }


    class SkiplistNode {
        /**
         * 本层的下一个跳表节点
         */
        public SkiplistNode next;

        /**
         * 存一个前驱节点方便添加与删除
         */
        public SkiplistNode prev;

        /**
         * 下一层索引位置
         */
        public SkiplistNode down;


        /**
         * 值
         */
        public int value;

        public SkiplistNode(SkiplistNode next, SkiplistNode down, int value) {
            this.next = next;
            this.down = down;
            this.value = value;
        }
    }
}



