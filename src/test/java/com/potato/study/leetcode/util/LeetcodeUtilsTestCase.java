package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * LeetcodeUtils 单测用例
 */
public class LeetcodeUtilsTestCase {

    @Test
    public void testBuildListByLeetcodeString() {
        ListNode head = LeetcodeUtils.buildListNodeByLeetcodeString("1->1->2->3->4->4");
        System.out.println(head);
    }


    @Test
    public void testGetListNodeInLeetcodeString() {
        ListNode head = LeetcodeUtils.buildListNodeByLeetcodeString("1->1->2->3->4->4");
        String str = LeetcodeUtils.getListNodeInLeetcodeString(head);
        Assert.assertEquals("1->1->2->3->4->4", str);
        System.out.println(str);
    }
}
