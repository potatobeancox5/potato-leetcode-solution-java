package com.potato.study.leetcodecn.p00382.t001;

import org.junit.Assert;

/**
 * 382. 链表随机节点
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。

 进阶:
 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？

 示例:

 // 初始化一个单链表 [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 solution.getRandom();

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-random-node
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 顺序比较
     * while i < s.len
     * 如果 si != tj j++
     * else i++ j++
     *
     * if i == s.len true
     * false
     *
     * 如果量比较多 使用hash map 记录 前缀对应结束的index
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abc";
        String t = "ahbgdc";
        boolean res = solution.isSubsequence(s, t);
        System.out.println(res);
        Assert.assertEquals(true, res);

        s = "axc";
        t = "ahbgdc";
        res = solution.isSubsequence(s, t);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
