package com.potato.study.leetcodecn.p01669.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 1669. 合并两个链表
 *
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。

 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。

 下图中蓝色边和节点展示了操作后的结果：


 请你返回结果链表的头指针。

  

 示例 1：



 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 输出：[0,1,2,1000000,1000001,1000002,5]
 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 示例 2：


 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 解释：上图中蓝色的边和节点为答案链表。
  

 提示：

 3 <= list1.length <= 104
 1 <= a <= b < list1.length - 1
 1 <= list2.length <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到 list1 中的 a位置之前的位置 和b 位置 之前的位置
     * 通过哨兵简化
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 设置 哨兵
        ListNode head = new ListNode(-1);
        head.next = list1;
        ListNode p = list1;
        ListNode pre = head;
        int index = 0;

        ListNode preA = null;
        ListNode headb = null;

        while (p != null) {
            if (index == a) {
                preA = pre;
            }
            if (index == b) {
                headb = p;
                break;
            }
            index++;
            p = p.next;
            pre = pre.next;
        }

        // 找到list2的尾结点
        ListNode pp = list2;
        ListNode tail = new ListNode(-1);
        tail.next = list2;
        while (pp != null) {
            pp = pp.next;
            tail = tail.next;
        }
        // 执行替换
        preA.next = list2;
        if (headb != null) {
            tail.next = headb.next;
        }
        return list1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode list1 = ListNodeUtil.arrayStringToListNode("[0,1,2,3,4,5]");
        ListNode list2= ListNodeUtil.arrayStringToListNode("[1000000,1000001,1000002]");
        int a = 3;
        int b = 4;
        ListNode listNode = solution.mergeInBetween(list1, a, b, list2);
        ListNodeUtil.printListNode(listNode);


        list1 = ListNodeUtil.arrayStringToListNode("[0,1,2,3,4,5,6]");
        list2= ListNodeUtil.arrayStringToListNode("[1000000,1000001,1000002,1000003,1000004]");
        a = 2;
        b = 5;
        listNode = solution.mergeInBetween(list1, a, b, list2);
        ListNodeUtil.printListNode(listNode);

        list1 = ListNodeUtil.arrayStringToListNode("[0,1,2]");
        list2= ListNodeUtil.arrayStringToListNode("[1000000,1000001,1000002,1000003]");
        a = 1;
        b = 1;
        listNode = solution.mergeInBetween(list1, a, b, list2);
        ListNodeUtil.printListNode(listNode);
    }
}
