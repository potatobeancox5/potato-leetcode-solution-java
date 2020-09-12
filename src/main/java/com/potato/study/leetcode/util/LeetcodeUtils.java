package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.ListNode;

/**
 * leet code 工具集合
 * 将leetcode 给出的 字符串或者 树形结构 快速转换成对应的接口
 */
public class LeetcodeUtils {

    /**
     * 通过leetcode 给的字符串（1->2->4） 生成一个链表
     * 返回 链表头节点
     * @param leetcodeString
     * @return
     */
    public static ListNode buildListNodeByLeetcodeString (String leetcodeString) {
        if (null == leetcodeString || "".equals(leetcodeString)) {
            return null;
        }
        String[] split = leetcodeString.split("->");
        if (split.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode p = head;
        for (int i = 1; i < split.length; i++) {
            p.next = new ListNode(Integer.parseInt(split[i]));
            p = p.next;
        }
        return head;
    }

    /**
     * 给一个数字链表 按照这个类型的字符串进行输出
     * 1->1->2->3->4->4
     * @param head
     * @return
     */
    public static String getListNodeInLeetcodeString (ListNode head) {
        if (head == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(head.val);
        if (head.next == null) {
            return builder.toString();
        }
        builder.append("->");
        builder.append(getListNodeInLeetcodeString(head.next));
        return builder.toString();
    }

}
