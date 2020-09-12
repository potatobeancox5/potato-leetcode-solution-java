package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.ListNode;
import org.junit.Test;

/**
 * LeetcodeUtils 单测用例
 */
public class LeetcodeUtilsTestCase {

    @Test
    public void testBuildListByLeetcodeString() {
        ListNode head = LeetcodeUtils.buildListByLeetcodeString("1->1->2->3->4->4");
        System.out.println(head);
    }
}
